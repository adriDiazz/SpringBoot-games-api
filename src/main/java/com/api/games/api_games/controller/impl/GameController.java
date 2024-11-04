package com.api.games.api_games.controller.impl;

import com.api.games.api_games.commons.dto.GameDto;
import com.api.games.api_games.services.impl.GameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.games.api_games.commons.entities.Game;
import com.api.games.api_games.controller.GameApi;
import com.api.games.api_games.services.GameService;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class GameController implements GameApi {

    private final GameServiceImpl gameService;

    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        Game savedGame = gameService.saveGame(game);
        return ResponseEntity.status(201).body(savedGame);
    }

    @Override
    public ResponseEntity<List<GameDto>> getAllGames() {
        var games = gameService.getAllGames();

        return ResponseEntity.ok(games);
    }

    @Override
    public ResponseEntity<GameDto> getGameById(Long id) {
        var games = gameService.getGameById(id);
        var gameDto = new GameDto(games.getName(), games.getGenre(), games.getPlatform(), games.getReleaseDate());

        return ResponseEntity.ok(gameDto);
    }

    @Override
    public ResponseEntity<GameDto> updateGame(Long id, GameDto game) {
        return ResponseEntity.ok(gameService.updateGameById(id, game));
    }

    @Override
    public ResponseEntity<Void> deleteGame(Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

}
