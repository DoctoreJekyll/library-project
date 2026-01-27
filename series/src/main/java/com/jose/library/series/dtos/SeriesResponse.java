package com.jose.library.series.dtos;

public record SeriesResponse(
    long id,
    String title,
    int seasons,
    int episodesPerSeason,
    int rating,
    String review
) {
}
