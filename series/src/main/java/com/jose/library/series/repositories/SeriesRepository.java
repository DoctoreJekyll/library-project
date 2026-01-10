package com.jose.library.series.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.series.model.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

}
