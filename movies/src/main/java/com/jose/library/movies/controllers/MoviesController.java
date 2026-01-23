package com.jose.library.movies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.movies.dtos.MovieRequest;
import com.jose.library.movies.dtos.MovieResponse;
import com.jose.library.movies.mappers.MovieMapper;
import com.jose.library.movies.model.Movie;
import com.jose.library.movies.services.MovieServicesImpl;

import java.util.List;

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
    private final MovieMapper movieMapper;

    public MoviesController(MovieServicesImpl movieServices, MovieMapper movieMapper) {
        this.movieServices = movieServices;
        this.movieMapper = movieMapper;
    }


    @GetMapping("user/{username}")
    public ResponseEntity<List<MovieResponse>> getMoviesByUsername(@PathVariable("username") String username) {
        List<MovieResponse> movies = movieServices.getMoviesByUsername(username)
        .stream()
        .map(movieMapper::toResponse)
        .toList();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/me")
    public ResponseEntity<List<MovieResponse>> getMyMovies(@RequestHeader("X-Auth-User") String user) {
        List<MovieResponse> movies = movieServices.getMoviesByUsername(user)
        .stream()
        .map(movieMapper::toResponse)
        .toList();

        return ResponseEntity.ok(movies);
    }

    @PostMapping()
    public ResponseEntity<MovieResponse> postMovie(@RequestBody MovieRequest movieRequest, @RequestHeader("X-Auth-User") String user) {
        Movie movie = movieMapper.toEntity(movieRequest,  user);
        Movie savedMovie = movieServices.saveMovie(movie, user);
        MovieResponse movieResponse = movieMapper.toResponse(savedMovie);
        
        return ResponseEntity.ok(movieResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @RequestBody MovieRequest movieRequest, @RequestHeader("X-Auth-User") String user) {
        Movie movie = movieMapper.toEntity(movieRequest,  user);
        Movie updatedMovie = movieServices.updateMovie(id, movie, user);
        MovieResponse movieResponse = movieMapper.toResponse(updatedMovie);

        return ResponseEntity.ok(movieResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        movieServices.deleteMovie(id, user);
        return ResponseEntity.ok().build();
    }

}