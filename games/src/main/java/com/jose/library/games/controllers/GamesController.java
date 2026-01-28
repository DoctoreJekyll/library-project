package com.jose.library.games.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.library.games.dtos.GamesRequest;
import com.jose.library.games.dtos.GamesResponse;
import com.jose.library.games.mappers.GamesMapper;
import com.jose.library.games.model.Games;
import com.jose.library.games.services.GamesServiceImpl;

import java.util.List;

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
    private final GamesMapper gamesMapper;

    public GamesController(GamesServiceImpl gamesService, GamesMapper gamesMapper) {
        this.gamesService = gamesService;
        this.gamesMapper = gamesMapper;
    }

    @GetMapping("user/{username}")
    public ResponseEntity<List<GamesResponse>> getGamesByUsername(@PathVariable("username") String username) {
        List<GamesResponse> games = gamesService.getGamesByUsername(username)
        .stream()
        .map(gamesMapper::toResponse)
        .toList();

        return ResponseEntity.ok(games);
    }

    @GetMapping("/me")
    public ResponseEntity<List<GamesResponse>> getMyGames(@RequestHeader("X-Auth-User") String user) {
        List<GamesResponse> games = gamesService.getGamesByUsername(user)
        .stream()
        .map(gamesMapper::toResponse)
        .toList();

        return ResponseEntity.ok(games);
    }

    @PostMapping()
    public ResponseEntity<GamesResponse> postMethodName(@RequestBody GamesRequest games, @RequestHeader("X-Auth-User") String user) {
        Games game = gamesMapper.toEntity(games,  user);
        Games savedGame = gamesService.createGame(game, user);
        GamesResponse gamesResponse = gamesMapper.toResponse(savedGame);
        return ResponseEntity.ok(gamesResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GamesResponse> updateGames(@PathVariable Long id, @RequestBody GamesRequest games, @RequestHeader("X-Auth-User") String user) {
        Games game = gamesMapper.toEntity(games, user);
        Games updatedGame = gamesService.updateGame(id, game, user);
        GamesResponse gamesResponse = gamesMapper.toResponse(updatedGame);
        return ResponseEntity.ok(gamesResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGames(@PathVariable Long id, @RequestHeader("X-Auth-User") String user) {
        gamesService.deleteGame(id, user);
        return ResponseEntity.ok().build();
    }

}
