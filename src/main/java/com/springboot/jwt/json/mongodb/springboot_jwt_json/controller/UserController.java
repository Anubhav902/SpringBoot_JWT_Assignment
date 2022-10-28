package com.springboot.jwt.json.mongodb.springboot_jwt_json.controller;

import com.springboot.jwt.json.mongodb.springboot_jwt_json.model.User;
import com.springboot.jwt.json.mongodb.springboot_jwt_json.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/signUp" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveUser(@RequestBody User user){
        return userService.signUp(user);
    }


    @PostMapping(value = "/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginUser(@RequestBody User user){
        return userService.login(user);
    }

}