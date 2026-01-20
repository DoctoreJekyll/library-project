package com.jose.library.games.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.games.model.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

    List<Games> findByUsername(String username);

    Optional<Games> findByIdAndUsername(Long id, String username);

}
