package com.api.games.api_games.commons.exceptions;

public class GameNotFoundError extends RuntimeException {
    public GameNotFoundError(String message) {
        super(message);
    }

    public GameNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }

}
