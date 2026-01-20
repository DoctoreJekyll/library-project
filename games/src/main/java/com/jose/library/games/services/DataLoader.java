package com.jose.library.games.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jose.library.games.model.Games;
import com.jose.library.games.repositories.GamesRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final GamesRepository gamesRepository;

    public DataLoader(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(gamesRepository.count() == 0) {
            gamesRepository.save(new Games(null, "The Legend of Zelda: Ocarina of Time", 12.5f, 9, "Epic adventure", "jose"));
            System.out.println("Dummy games added!");
        }
    }
}

