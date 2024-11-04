package com.api.games.api_games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.games.api_games.commons.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findByName(String name);

}
