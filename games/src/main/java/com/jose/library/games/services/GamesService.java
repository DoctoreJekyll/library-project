package com.jose.library.games.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.games.model.Games;

@Service
public interface GamesService {
    List<Games> getGamesByUsername(String username);
    Optional<Games> getGameByIdAndUsername(Long id, String username);
    Games createGame(Games game, String username);
    Games updateGame(Long id, Games game, String username);
    void deleteGame(Long id, String username);
}
