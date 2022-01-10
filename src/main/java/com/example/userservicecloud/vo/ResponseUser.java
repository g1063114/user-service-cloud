package com.example.userservicecloud.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResponseUser {

    private String name;
    private String email;
    private String userId;

    private List<ResponseOrder> orders;

    public ResponseUser(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }
}
