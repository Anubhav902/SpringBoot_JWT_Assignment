package com.springboot.jwt.json.mongodb.springboot_jwt_json.service;

import com.springboot.jwt.json.mongodb.springboot_jwt_json.model.Movie;
import com.springboot.jwt.json.mongodb.springboot_jwt_json.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private TokenService tokenService;

    public List<Movie> getMovies(){
        List<Movie> result = repository.findAll();
        return result;
    }

    public String saveMovie(Movie movie){
        Movie savedMovie = repository.save(movie);
        return "Movie Created" + savedMovie;
    }
}