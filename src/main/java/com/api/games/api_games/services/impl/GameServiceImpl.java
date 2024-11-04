package com.api.games.api_games.services.impl;

import com.api.games.api_games.commons.dto.GameDto;
import com.api.games.api_games.services.GameService;
import org.springframework.stereotype.Service;

import com.api.games.api_games.commons.entities.Game;
import com.api.games.api_games.commons.exceptions.ExistingGameError;
import com.api.games.api_games.commons.exceptions.GameNotFoundError;
import com.api.games.api_games.repositories.GameRepository;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game game) {
        Game isGameAlreadySaved = gameRepository.findByName(game.getName());

        if (isGameAlreadySaved != null) {
            throw new ExistingGameError("Game already exists");
        }

        return gameRepository.save(game);
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundError("Game not found"));
    }

    @Override
    public GameDto updateGameById(Long id, GameDto game) {
        Game currentGame = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundError("Game not found for the given ID"));

        currentGame.setName(game.name());
        currentGame.setGenre(game.genre());
        currentGame.setPlatform(game.platform());
        currentGame.setReleaseDate(game.releaseDate());

        Game updatedGame = gameRepository.save(currentGame);

        return new GameDto(updatedGame.getName(), updatedGame.getGenre(), updatedGame.getPlatform(),
                updatedGame.getReleaseDate());
    }

    @Override
    public List<GameDto> getAllGames() {
        return gameRepository.findAll().stream()
                .map(g -> new GameDto(g.getName(), g.getGenre(), g.getPlatform(), g.getReleaseDate())).toList();
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
