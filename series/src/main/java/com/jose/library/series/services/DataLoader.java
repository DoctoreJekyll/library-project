package com.jose.library.series.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jose.library.series.model.Series;
import com.jose.library.series.repositories.SeriesRepository;


@Component
public class DataLoader implements CommandLineRunner {

    private final SeriesRepository seriesRepository;

    public DataLoader(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(seriesRepository.count() == 0) {
            seriesRepository.save(new Series(null, "Breaking Bad", 5, 62, 10, "A high school chemistry teacher turned methamphetamine producer."));
            seriesRepository.save(new Series(null, "Stranger Things", 4, 34, 9, "A group of kids in the 80s face supernatural forces in their small town."));
            System.out.println("Dummy series added!");
        }
    }
}

