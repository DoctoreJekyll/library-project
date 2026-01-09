package com.jose.library.movies.services;

import com.jose.library.movies.model.Movie;
import com.jose.library.movies.repositories.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(movieRepository.count() == 0) {
            movieRepository.save(new Movie(null, "Inception", LocalDate.of(2010, 7, 16), 148, 9, "Mind-bending thriller"));
            movieRepository.save(new Movie(null, "The Matrix", LocalDate.of(1999, 3, 31), 136, 10, "Sci-fi classic"));
            movieRepository.save(new Movie(null, "Interstellar", LocalDate.of(2014, 11, 7), 169, 9, "Epic space journey"));
            System.out.println("Dummy movies added!");
        }
    }
}

