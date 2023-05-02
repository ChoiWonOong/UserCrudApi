package com.example.demo.repository.user;

import com.example.demo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define Method with JPA
    //  [return Type] findBy[field Name](Datatype field);
    Optional<User> findByName(String name);

}
