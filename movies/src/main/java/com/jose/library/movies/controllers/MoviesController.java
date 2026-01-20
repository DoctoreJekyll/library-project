package com.jose.library.movies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.movies.model.Movie;
import com.jose.library.movies.services.MovieServicesImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MovieServicesImpl movieServices;

    public MoviesController(MovieServicesImpl movieServices) {
        this.movieServices = movieServices;
    }


    @GetMapping("user/{username}")
    public ResponseEntity<?> getMoviesByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(movieServices.getMoviesByUsername(username));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyMovies(@RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(movieServices.getMoviesByUsername(user));
    }

    @PostMapping()
    public ResponseEntity<?> postMethodName(@RequestBody Movie movie, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(movieServices.saveMovie(movie, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody Movie movie, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(movieServices.updateMovie(id, movie, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        movieServices.deleteMovie(id, user);
        return ResponseEntity.ok().build();
    }

}