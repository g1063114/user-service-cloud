package com.example.userservicecloud.dto;

import com.example.userservicecloud.entity.UserEntity;
import com.example.userservicecloud.vo.ResponseOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private String password;
    private String userId;
    private LocalDateTime createdAt;
    private String encryptedPwd;
    private List<ResponseOrder> orders;

    public UserEntity toEntity(UserDto userDto){
        return new UserEntity(this.name, this.email, this.userId, this.encryptedPwd, this.createdAt);
    }
}
