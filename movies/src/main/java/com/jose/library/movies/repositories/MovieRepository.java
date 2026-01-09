package com.jose.library.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.movies.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
