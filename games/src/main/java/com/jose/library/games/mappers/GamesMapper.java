package com.jose.library.games.mappers;

import com.jose.library.games.dtos.GamesRequest;
import com.jose.library.games.dtos.GamesResponse;
import com.jose.library.games.model.Games;

public class GamesMapper {

    public Games toEntity(GamesRequest dto, String username) {
        Games game = new Games();
        game.setTitle(dto.title());
        game.setDurationInHours(dto.durationInHours());
        game.setRating(dto.rating());
        game.setReview(dto.review());
        game.setUsername(username);
        return game;
    }

    public GamesResponse toResponse(Games game) {
        return new GamesResponse(
            game.getId(),
            game.getTitle(),
            game.getDurationInHours(),
            game.getRating(),
            game.getReview()
        );
    }

}
