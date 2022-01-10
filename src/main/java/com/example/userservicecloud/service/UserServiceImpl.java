package com.example.userservicecloud.service;

import com.example.userservicecloud.dto.UserDto;
import com.example.userservicecloud.entity.UserEntity;
import com.example.userservicecloud.repository.UserRepository;
import com.example.userservicecloud.vo.ResponseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        userDto.setEncryptedPwd(passwordEncoder.encode(userDto.getPassword()));
        userDto.setCreatedAt(LocalDateTime.now());
        userRepository.save(userDto.toEntity(userDto));
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        UserDto userDto = new UserDto();
        userDto.setName(userEntity.getName());
        userDto.setEncryptedPwd(userEntity.getEncryptedPwd());
        userDto.setEmail(userEntity.getEmail());
        userDto.setCreatedAt(userEntity.getCreatedAt());

        List<ResponseOrder> orders = new ArrayList<>();
        userDto.setOrders(orders);

        return userDto;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }
}
