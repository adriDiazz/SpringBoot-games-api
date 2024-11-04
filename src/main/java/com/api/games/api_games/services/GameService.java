package com.api.games.api_games.services;

import com.api.games.api_games.commons.dto.GameDto;
import com.api.games.api_games.commons.entities.Game;

import java.util.List;

public interface GameService {
    public Game saveGame(Game game);

    public Game getGameById(Long id);

    public GameDto updateGameById(Long id, GameDto game);

    public List<GameDto> getAllGames();

    public void deleteGame(Long id);
}
