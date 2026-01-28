package com.jose.library.games.dtos;

public record GamesResponse(
    Long id,
    String title,
    float durationInHours,
    int rating,
    String review
) {

}
