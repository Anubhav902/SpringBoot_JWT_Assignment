package com.springboot.jwt.json.mongodb.springboot_jwt_json.repository;

import com.springboot.jwt.json.mongodb.springboot_jwt_json.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    public List<User> getUsersByEmail(String email);
}
