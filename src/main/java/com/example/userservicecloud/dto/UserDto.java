package com.example.userservicecloud.dto;

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
    private LocalDateTime createAt;
    private String encryptedPwd;
}
