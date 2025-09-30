package com.example.serviceuser.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private Long userId;

    private String username;

    private String email;

    private UserDto(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public static UserDto from(Long userId, String username, String email) {
        return new UserDto(userId, username, email);
    }

}
