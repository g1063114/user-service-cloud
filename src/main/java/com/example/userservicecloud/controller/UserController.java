package com.example.userservicecloud.controller;

import com.example.userservicecloud.dto.UserDto;
import com.example.userservicecloud.service.UserService;
import com.example.userservicecloud.vo.Greeting;
import com.example.userservicecloud.vo.RequestUser;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private Environment env;
    private UserService userService;

    @Autowired
    private Greeting greeting;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }

    @GetMapping("/users")
    public String createUser(RequestUser requestUser){
        UserDto userDto = new UserDto();
        userDto.setEmail(requestUser.getEmail());
        userDto.setName(requestUser.getName());
        userDto.setPassword(requestUser.getPassword());
        userService.createUser(userDto);

        return "Create User Method call";
    }
}
