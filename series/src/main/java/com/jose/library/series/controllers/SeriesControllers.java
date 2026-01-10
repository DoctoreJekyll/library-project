package com.jose.library.series.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.series.model.Series;
import com.jose.library.series.services.SeriesServicesImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/series")
public class SeriesControllers {

    private final SeriesServicesImpl seriesServicesImpl;
    public SeriesControllers(SeriesServicesImpl seriesServicesImpl) {
        this.seriesServicesImpl = seriesServicesImpl;
    }

    @GetMapping()
    public ResponseEntity<?> getListAllSeries() {
        return ResponseEntity.ok(seriesServicesImpl.getAllSeries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSerie(@PathVariable("id") Long id) {
        return ResponseEntity.ok(seriesServicesImpl.getSeriesById(id));
    }

    @PostMapping()
    public ResponseEntity<?>createSerie(@RequestBody Series series) {     
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesServicesImpl.createSeries(series));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSerie(@PathVariable Long id, @RequestBody Series series) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesServicesImpl.updateSeries(id, series));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSerie(@PathVariable Long id) {
        seriesServicesImpl.deleteSeries(id);
        return ResponseEntity.noContent().build();
    }

}
