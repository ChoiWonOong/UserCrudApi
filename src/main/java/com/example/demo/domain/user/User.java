package com.example.demo.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // protected no-argsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String name;
    private Integer age;
    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
