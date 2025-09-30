package com.example.serviceuser.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Getter
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static UserEntity of(String name, String email) {
        return new UserEntity(name, email);
    }
}
