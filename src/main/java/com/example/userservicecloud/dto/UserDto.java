package com.example.userservicecloud.dto;

import com.example.userservicecloud.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private String password;
    private String userId;
    private LocalDateTime createdAt;
    private String encryptedPwd;

    public UserEntity toEntity(UserDto userDto){
        return new UserEntity(this.name, this.email, this.userId, this.encryptedPwd, this.createdAt);
    }
}
