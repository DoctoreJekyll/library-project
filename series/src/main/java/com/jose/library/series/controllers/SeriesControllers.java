package com.jose.library.series.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.series.model.Series;
import com.jose.library.series.services.SeriesServicesImpl;

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
    public SeriesControllers(SeriesServicesImpl seriesServicesImpl) {
        this.seriesServicesImpl = seriesServicesImpl;
    }

    @GetMapping("user/{username}")
    public ResponseEntity<?> getSeriesByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(seriesServicesImpl.getSeriesByUsername(username));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMySeries(@RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(seriesServicesImpl.getSeriesByUsername(user));
    }

    @PostMapping()
    public ResponseEntity<?> postSeries(@RequestBody Series series, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(seriesServicesImpl.createSeries(series, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeries(@PathVariable Long id, @RequestBody Series series, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(seriesServicesImpl.updateSeries(id, series, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeries(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        seriesServicesImpl.deleteSeries(id, user);
        return ResponseEntity.ok().build();
    }

}
