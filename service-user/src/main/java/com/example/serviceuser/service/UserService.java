package com.example.serviceuser.service;

import com.example.serviceuser.dto.UserDto;
import com.example.serviceuser.dto.UserSignUpRequest;
import com.example.serviceuser.entity.UserEntity;
import com.example.serviceuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(UserSignUpRequest request) {
        UserEntity userEntity = UserEntity.of(request.getUsername(), request.getEmail());
        userRepository.save(userEntity);
    }

    public UserDto getUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("없음"));
        return UserDto.from(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
    }


}
