package com.jose.library.series.dtos;

public record SeriesRequest(
    String title,
    int seasons,
    int episodes,
    int rating,
    String review
) {

}
