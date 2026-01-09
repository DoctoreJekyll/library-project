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
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie;
        }
        return Optional.empty();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        existingMovie.setName(movie.getName());
        existingMovie.setViewDate(movie.getViewDate());
        existingMovie.setDurationInMinutes(movie.getDurationInMinutes());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReview(movie.getReview());

        return movieRepository.save(existingMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
