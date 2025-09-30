package com.example.serviceuser.controller;

import com.example.serviceuser.dto.UserDto;
import com.example.serviceuser.dto.UserSignUpRequest;
import com.example.serviceuser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void signUpApi(UserSignUpRequest request) {
        userService.signUp(request);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserApi(@PathVariable Long userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @GetMapping("/health-check")
    public String healthCheckApi() {
        return "Application is Running";
    }

}
