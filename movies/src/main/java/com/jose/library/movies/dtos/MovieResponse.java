package com.jose.library.movies.dtos;

import java.time.LocalDate;

public record MovieResponse(
    Long id,
    String name,
    LocalDate viewDate,
    float durationInMinutes,
    int rating,
    String review
) {

}
