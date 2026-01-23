package com.jose.library.movies.dtos;

import java.time.LocalDate;

public record MovieRequest(
    String name,
    LocalDate viewDate,
    float durationInMinutes,
    int rating,
    String review
) {

}
