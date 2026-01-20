package com.jose.library.series.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.series.model.Series;
import com.jose.library.series.repositories.SeriesRepository;

@Service
public class SeriesServicesImpl implements SeriesService {

    private final SeriesRepository seriesRepository;
    public SeriesServicesImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }


    @Override
    public List<Series> getSeriesByUsername(String username) {
        return seriesRepository.findByUsername(username);
    }



    @Override
    public Optional<Series> getSeriesByIdAndUsername(Long id, String username) {
        Optional<Series> series = seriesRepository.findByIdAndUsername(id, username);
        if (series.isPresent()) {
            return series;
        }
        return Optional.empty();
    }



    @Override
    public Series createSeries(Series series, String username) {
        series.setUsername(username);
        return seriesRepository.save(series);
    }

    @Override
    public Series updateSeries(Long id, Series series, String username) {
        Series existingSeries = seriesRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Series not found"));
        existingSeries.setTitle(series.getTitle());
        existingSeries.setEpisodes(series.getEpisodes());
        existingSeries.setSeasons(series.getSeasons());
        existingSeries.setRating(series.getRating());
        existingSeries.setReview(series.getReview());
        return seriesRepository.save(existingSeries);
    }


    @Override
    public void deleteSeries(Long id, String username) {
        Series existingSeries = seriesRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Series not found"));
        seriesRepository.delete(existingSeries);
    }

}
