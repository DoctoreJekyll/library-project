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
    public List<Series> getAllSeries() {
        List<Series> seriesList = seriesRepository.findAll();
        return seriesList;
    }

    @Override
    public Optional<Series> getSeriesById(Long id) {
        Optional<Series> series = seriesRepository.findById(id);
        if (series.isPresent()) {
            return series;
        }
        return Optional.empty();
    }

    @Override
    public Series createSeries(Series series) {
        Series newSeries = seriesRepository.save(series);
        return newSeries;   
    }

    @Override
    public Series updateSeries(Long id, Series series) {
        Series existingSeries = seriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Series not found"));
        existingSeries.setTitle(series.getTitle());
        existingSeries.setEpisodes(series.getEpisodes());
        existingSeries.setSeasons(series.getSeasons());
        existingSeries.setRating(series.getRating());
        existingSeries.setReview(series.getReview());
        return seriesRepository.save(existingSeries);
    }

    @Override
    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }

}
