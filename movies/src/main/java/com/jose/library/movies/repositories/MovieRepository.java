package com.jose.library.movies.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.movies.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findByUsername(String username);

    Optional<Movie> findByIdAndUsername(Long id, String username);

}
