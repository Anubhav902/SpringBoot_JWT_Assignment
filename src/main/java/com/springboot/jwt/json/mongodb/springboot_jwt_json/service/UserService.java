package com.springboot.jwt.json.mongodb.springboot_jwt_json.service;

import com.springboot.jwt.json.mongodb.springboot_jwt_json.model.User;
import com.springboot.jwt.json.mongodb.springboot_jwt_json.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository repository,TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }


    public String signUp(User user){
        User savedUser = repository.save(user);
        return "User Created : " + savedUser;
    }

    public String login(User user){
        List<User> repoUser = repository.getUsersByEmail(user.getEmail());

        if(repoUser.size()==0){
            return "Authorization Failed";
        }

        if(!user.getPassword().equals(repoUser.get(0).getPassword())){
            return "Authorization Failed";
        }
        return "Login Successful "+ "data: "+ repoUser.get(0) + "token : "+ tokenService.createToken(repoUser.get(0).getId());
    }
}
