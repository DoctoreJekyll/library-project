package com.jose.library.games.services;

import java.util.List;
import java.util.Optional;

import com.jose.library.games.model.Games;
import com.jose.library.games.repositories.GamesRepository;

public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;
    
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Games> getAllGames() {
        List<Games> games = gamesRepository.findAll();
        return games;
    }

    @Override
    public Optional<Games> getGameById(Long id) {
        Optional<Games> game = gamesRepository.findById(id);
        if (game.isPresent()) {
            return game;
        }
        return Optional.empty();
    }

    @Override
    public Games createGame(Games game) {
        return gamesRepository.save(game);
    }

    @Override
    public Games updateGame(Long id, Games game) {
        Games existingGame = gamesRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));

        existingGame.setTitle(game.getTitle());
        existingGame.setDurationInHours(game.getDurationInHours());
        existingGame.setRating(game.getRating());
        existingGame.setReview(game.getReview());

        return gamesRepository.save(existingGame);
    }

    @Override
    public void deleteGame(Long id) {
        gamesRepository.deleteById(id);
    }

}
