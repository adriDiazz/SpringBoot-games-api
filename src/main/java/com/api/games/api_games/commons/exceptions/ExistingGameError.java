package com.api.games.api_games.commons.exceptions;

public class ExistingGameError extends RuntimeException {
    public ExistingGameError(String message) {
        super(message);
    }

    public ExistingGameError(String message, Throwable cause) {
        super(message, cause);
    }
}
