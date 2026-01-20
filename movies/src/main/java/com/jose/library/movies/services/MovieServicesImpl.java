package com.jose.library.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.movies.model.Movie;
import com.jose.library.movies.repositories.MovieRepository;

@Service
public class MovieServicesImpl implements MovieServices {

    private final MovieRepository movieRepository;

    public MovieServicesImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMoviesByUsername(String username) {
        List<Movie> movies = movieRepository.findByUsername(username);
        return movies;
    }

    @Override
    public Optional<Movie> getMovieByIdAndUsername(Long id, String username) {
        Optional<Movie> movie = movieRepository.findByIdAndUsername(id, username);
        if (movie.isPresent()) {
            return movie;
        }
        return Optional.empty();
    }

    @Override
    public Movie saveMovie(Movie movie, String username) {
        movie.setUsername(username);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie, String username) {
        Movie existingMovie = movieRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Movie not found"));

        existingMovie.setName(movie.getName());
        existingMovie.setViewDate(movie.getViewDate());
        existingMovie.setDurationInMinutes(movie.getDurationInMinutes());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReview(movie.getReview());

        return movieRepository.save(existingMovie);
    }

    @Override
    public void deleteMovie(Long id, String username) {
        Movie existingMovie = movieRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Movie not found"));
        movieRepository.delete(existingMovie);
    }

}
