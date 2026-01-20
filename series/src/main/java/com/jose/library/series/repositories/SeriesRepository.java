package com.jose.library.series.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.series.model.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findByUsername(String username);

    Optional<Series> findByIdAndUsername(Long id, String username);
}
