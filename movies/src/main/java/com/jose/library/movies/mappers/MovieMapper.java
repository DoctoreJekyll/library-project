package com.jose.library.movies.mappers;

import com.jose.library.movies.dtos.MovieRequest;
import com.jose.library.movies.dtos.MovieResponse;
import com.jose.library.movies.model.Movie;

public class MovieMapper {


    public Movie toEntity(MovieRequest dto, String username) {
        Movie movie = new Movie();
        movie.setName(dto.name());
        movie.setViewDate(dto.viewDate());
        movie.setDurationInMinutes(dto.durationInMinutes());
        movie.setRating(dto.rating());
        movie.setReview(dto.review());
        movie.setUsername(username);
        return movie;
    }

    public MovieResponse toResponse(Movie movie) {
        return new MovieResponse(
            movie.getId(),
            movie.getName(),
            movie.getViewDate(),
            movie.getDurationInMinutes(),
            movie.getRating(),
            movie.getReview()
        );
    }

}
