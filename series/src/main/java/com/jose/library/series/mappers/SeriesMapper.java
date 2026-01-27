package com.jose.library.series.mappers;

import com.jose.library.series.dtos.SeriesRequest;
import com.jose.library.series.dtos.SeriesResponse;
import com.jose.library.series.model.Series;

public class SeriesMapper {

    public Series toEntity(SeriesRequest dto, String username) {
        Series series = new Series();
        series.setTitle(dto.title());
        series.setSeasons(dto.seasons());
        series.setEpisodes(dto.episodes());
        series.setRating(dto.rating());
        series.setReview(dto.review());
        series.setUsername(username);
        return series;
    }

    public SeriesResponse toResponse(Series series) {
        return new SeriesResponse(
            series.getId(),
            series.getTitle(),
            series.getSeasons(),
            series.getEpisodes(),
            series.getRating(),
            series.getReview()
        );
    }

}
