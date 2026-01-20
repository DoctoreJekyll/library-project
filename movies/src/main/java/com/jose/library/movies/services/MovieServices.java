package com.jose.library.movies.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.library.movies.model.Movie;

@Service
public interface MovieServices {
    List<Movie> getMoviesByUsername(String username);
    Optional<Movie> getMovieByIdAndUsername(Long id, String username);
    Movie saveMovie(Movie movie, String username);
    Movie updateMovie(Long id, Movie movie, String username);
    void deleteMovie(Long id, String username);
}
