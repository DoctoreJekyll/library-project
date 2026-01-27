package com.jose.library.series.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.series.dtos.SeriesRequest;
import com.jose.library.series.dtos.SeriesResponse;
import com.jose.library.series.mappers.SeriesMapper;
import com.jose.library.series.model.Series;
import com.jose.library.series.services.SeriesServicesImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/series")
public class SeriesControllers {

    private final SeriesServicesImpl seriesServicesImpl;
    private final SeriesMapper seriesMapper;

    public SeriesControllers(SeriesServicesImpl seriesServicesImpl, SeriesMapper seriesMapper) {
        this.seriesServicesImpl = seriesServicesImpl;
        this.seriesMapper = seriesMapper;
    }

    @GetMapping("user/{username}")
    public ResponseEntity<List<SeriesResponse>> getSeriesByUsername(@PathVariable("username") String username) {
        List<SeriesResponse> series = seriesServicesImpl.getSeriesByUsername(username)
        .stream()
        .map(seriesMapper::toResponse)
        .toList();

        return ResponseEntity.ok(series);
    }

    @GetMapping("/me")
    public ResponseEntity<List<SeriesResponse>> getMySeries(@RequestHeader("X-Auth-User") String user) {
        List<SeriesResponse> series = seriesServicesImpl.getSeriesByUsername(user)
        .stream()
        .map(seriesMapper::toResponse)
        .toList();

        return ResponseEntity.ok(series);
    }

    @PostMapping()
    public ResponseEntity<SeriesResponse> postSeries(@RequestBody SeriesRequest series, @RequestHeader("X-Auth-User") String user) {
        Series seriesEntity = seriesMapper.toEntity(series,  user);
        Series savedSeries = seriesServicesImpl.createSeries(seriesEntity, user);
        SeriesResponse seriesResponse = seriesMapper.toResponse(savedSeries);
        return ResponseEntity.ok(seriesResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeries(@PathVariable Long id, @RequestBody SeriesRequest series, @RequestHeader("X-Auth-User") String user) {
        Series seriesEntity = seriesMapper.toEntity(series,  user);
        Series updatedSeries = seriesServicesImpl.updateSeries(id, seriesEntity, user);
        SeriesResponse seriesResponse = seriesMapper.toResponse(updatedSeries);
        return ResponseEntity.ok(seriesResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeries(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        seriesServicesImpl.deleteSeries(id, user);
        return ResponseEntity.ok().build();
    }

}
