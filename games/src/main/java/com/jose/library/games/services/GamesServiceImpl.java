package com.jose.library.games.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.library.games.model.Games;
import com.jose.library.games.repositories.GamesRepository;

@Service
public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;
    
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }


    @Override
    public List<Games> getGamesByUsername(String username) {
        List<Games> games = gamesRepository.findByUsername(username);
        return games;
    }


    @Override
    public Optional<Games> getGameByIdAndUsername(Long id, String username) {
        Optional<Games> game = gamesRepository.findByIdAndUsername(id, username);
        if (game.isPresent()) {
            return game;
        }
        return Optional.empty();
    }


    @Override
    public Games createGame(Games game, String username) {
        game.setUsername(username);
        return gamesRepository.save(game);
    }


    @Override
    public Games updateGame(Long id, Games game, String username) {
        Games existingGame = gamesRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Game not found"));

        existingGame.setTitle(game.getTitle());
        existingGame.setDurationInHours(game.getDurationInHours());
        existingGame.setRating(game.getRating());
        existingGame.setReview(game.getReview());

        return gamesRepository.save(existingGame);
    }


    @Override
    public void deleteGame(Long id, String username) {
        Games existingGame = gamesRepository.findByIdAndUsername(id, username).orElseThrow(() -> new RuntimeException("Game not found"));
        gamesRepository.delete(existingGame);
    }

}
