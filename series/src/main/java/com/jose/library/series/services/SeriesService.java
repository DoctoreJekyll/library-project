package com.jose.library.series.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.series.model.Series;

@Service
public interface SeriesService {
    List<Series> getAllSeries();
    Optional<Series> getSeriesById(Long id);
    Series createSeries(Series series);
    Series updateSeries(Long id, Series series);
    void deleteSeries(Long id);
}
