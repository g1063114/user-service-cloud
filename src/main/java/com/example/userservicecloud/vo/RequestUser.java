package com.example.userservicecloud.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequestUser {

    @NotNull(message = "이름은 필수 항목 입니다.")
    private String name;

    @NotNull(message = "이메일은 필수 항목 입니다.")
    private String email;

    @NotNull(message = "비밀번호는 필수 항목 입니다.")
    private String password;
}
