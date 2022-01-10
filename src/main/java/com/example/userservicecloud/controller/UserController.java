package com.example.userservicecloud.controller;

import com.example.userservicecloud.dto.UserDto;
import com.example.userservicecloud.entity.UserEntity;
import com.example.userservicecloud.service.UserService;
import com.example.userservicecloud.vo.Greeting;
import com.example.userservicecloud.vo.RequestUser;
import com.example.userservicecloud.vo.ResponseUser;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-service")
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
        return String.format("It's Working in User Service on PORT %s",env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser){
        UserDto userDto = new UserDto();
        userDto.setEmail(requestUser.getEmail());
        userDto.setName(requestUser.getName());
        userDto.setPassword(requestUser.getPassword());
        userService.createUser(userDto);

        ResponseUser responseUser = new ResponseUser();
        responseUser.setName(userDto.getName());
        responseUser.setEmail(userDto.getEmail());
        responseUser.setUserId(userDto.getUserId());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach( v -> {
            result.add(new ResponseUser(v.getName(), v.getEmail(), v.getUserId()));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId){
        UserDto userDto = userService.getUserByUserId(userId);

        ResponseUser responseUser = new ResponseUser(userDto.getName(), userDto.getEmail(), userDto.getUserId());

        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }
}
