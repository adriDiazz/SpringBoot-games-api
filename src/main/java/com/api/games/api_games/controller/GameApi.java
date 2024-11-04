package com.api.games.api_games.controller;

import java.util.List;

import com.api.games.api_games.commons.dto.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.games.api_games.commons.constants.ApiPathsVariables;
import com.api.games.api_games.commons.entities.Game;

@RequestMapping(ApiPathsVariables.API_PATH + ApiPathsVariables.GAMES_PATH)
public interface GameApi {

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game);

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGames();

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable Long id);

    @PutMapping("/{id}")
    public ResponseEntity<GameDto> updateGame(@PathVariable Long id, @RequestBody GameDto game);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id);
}
