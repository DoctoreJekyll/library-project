package com.jose.library.games.dtos;

public record GamesRequest(
    String title,
    float durationInHours,
    int rating,
    String review
) {

}
