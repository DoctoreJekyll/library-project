package com.jose.library.games.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.games.model.Games;
import com.jose.library.games.services.GamesServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/games")
public class GamesController {

    private final GamesServiceImpl gamesService;
    public GamesController(GamesServiceImpl gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllGames() {
        return ResponseEntity.ok(gamesService.getAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(gamesService.getGameById(id));
    }

    @PostMapping()
    public ResponseEntity<?> saveGame(@RequestBody Games games) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gamesService.createGame(games));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGame(@PathVariable("id") Long id, @RequestBody Games games) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gamesService.updateGame(id, games));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable("id") Long id) {
        gamesService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

}
