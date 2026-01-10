package com.jose.library.games.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.games.model.Games;

@Service
public interface GamesService {
    List<Games> getAllGames();
    Optional<Games> getGameById(Long id);
    Games createGame(Games game);
    Games updateGame(Long id, Games game);
    void deleteGame(Long id);
}
