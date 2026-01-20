package com.jose.library.series.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.series.model.Series;

@Service
public interface SeriesService {
    List<Series> getSeriesByUsername(String username);
    Optional<Series> getSeriesByIdAndUsername(Long id, String username);
    Series createSeries(Series series, String username);
    Series updateSeries(Long id, Series series, String username);
    void deleteSeries(Long id, String username);
}
