package com.jose.library.movies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.movies.model.Movie;
import com.jose.library.movies.services.MovieServicesImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MovieServicesImpl movieServices;

    public MoviesController(MovieServicesImpl movieServices) {
        this.movieServices = movieServices;
    }

    @GetMapping()
    public ResponseEntity<?> getListOfAllMovies() {
        return ResponseEntity.ok(movieServices.getAllMovies());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieServices.getMovieById(id).orElseThrow());
    }
    
    @PostMapping()
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieServices.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> putMethodName(@PathVariable("id") Long id, @RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieServices.updateMovie(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        movieServices.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
