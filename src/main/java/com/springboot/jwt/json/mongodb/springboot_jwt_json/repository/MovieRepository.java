package com.springboot.jwt.json.mongodb.springboot_jwt_json.repository;

import com.springboot.jwt.json.mongodb.springboot_jwt_json.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}