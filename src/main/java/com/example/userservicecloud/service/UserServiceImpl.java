package com.example.userservicecloud.service;

import com.example.userservicecloud.dto.UserDto;
import com.example.userservicecloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        userDto.setEncryptedPwd("encrypted");
        userDto.setCreatedAt(LocalDateTime.now());
        userRepository.save(userDto.toEntity(userDto));
        return userDto;
    }
}
