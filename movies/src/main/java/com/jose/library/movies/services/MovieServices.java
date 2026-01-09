package com.jose.library.movies.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.library.movies.model.Movie;

@Service
public interface MovieServices {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(Long id);
    Movie saveMovie(Movie movie);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovie(Long id);
}
