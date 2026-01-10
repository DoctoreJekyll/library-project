package com.jose.library.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.library.games.model.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

}
