package com.example.userservicecloud.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Greeting {
    @Value("${greeting.message}")   // application.yml 에 설정한 값을 읽어올 수 있다.
    private String message;
}
