package com.jose.library.games.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.games.model.Games;
import com.jose.library.games.services.GamesServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/games")
public class GamesController {

    private final GamesServiceImpl gamesService;
    public GamesController(GamesServiceImpl gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping("user/{username}")
    public ResponseEntity<?> getGamesByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(gamesService.getGamesByUsername(username));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyGames(@RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(gamesService.getGamesByUsername(user));
    }

    @PostMapping()
    public ResponseEntity<?> postMethodName(@RequestBody Games games, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(gamesService.createGame(games, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGames(@PathVariable Long id, @RequestBody Games games, @RequestHeader("X-Auth-User") String user) {
        return ResponseEntity.ok(gamesService.updateGame(id, games, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGames(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        gamesService.deleteGame(id, user);
        return ResponseEntity.ok().build();
    }

}
