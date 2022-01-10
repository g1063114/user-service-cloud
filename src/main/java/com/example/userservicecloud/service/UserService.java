package com.example.userservicecloud.service;

import com.example.userservicecloud.dto.UserDto;
import com.example.userservicecloud.entity.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
