package com.example.demo.service.user;

import com.example.demo.domain.user.User;
import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }//connect controller with service
    public void saveUser(UserCreateRequest request){
        //make new user with the values in userCreateRequest and save the user
        userRepository.save(new User(request.getName(), request.getAge()));
    }
    public void deleteUser(String name){
        //find user by name, exception handling
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);        //delete user
    }
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();            //get all users
        List<UserResponse> userResponses = new ArrayList<UserResponse>();  //initialize List
        for(int i=0; i<users.size();i++) {
            User user = users.get(i);                           //get each user
            UserResponse userResponse =
                    new UserResponse(user.getId(), user.getName(), user.getAge());  //transform user into userResponse
            userResponses.add(userResponse);                    //add userResponse into List
        }

        return userResponses;                                   //return List

        //same Operation

        //return userRepository.findAll().stream()
        //      .map(user->new UserResponse(user.getId(),user.getName(),user.getAge()))
        //      .collect(Collectors.toList());
    }
    public void updateUser(UserUpdateRequest request){
        //find user by id, exception handling
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        //change user name with value in userUpdaterRequest
        user.setName(request.getName());
        userRepository.save(user);      //save changed user
    }
}
