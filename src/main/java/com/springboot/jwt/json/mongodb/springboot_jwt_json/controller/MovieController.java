package com.springboot.jwt.json.mongodb.springboot_jwt_json.controller;

import com.springboot.jwt.json.mongodb.springboot_jwt_json.model.Movie;
import com.springboot.jwt.json.mongodb.springboot_jwt_json.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping(value = "/saveMovie" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveMovie(@RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @GetMapping("/getMovies")
    public List<Movie> getMovie(HttpServletRequest req, HttpServletResponse res) throws IOException {
        return  service.getMovies();
    }
}