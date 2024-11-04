package com.api.games.api_games.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.games.api_games.commons.dto.ErrorApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistingGameError.class)
    public ResponseEntity<ErrorApiResponse> handleExistingGameError(ExistingGameError e) {
        var errorResponse = ErrorApiResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();

        log.error("New Exception:", e.getMessage());

        return ResponseEntity.status(409).body(errorResponse);
    }

    @ExceptionHandler(GameNotFoundError.class)
    public ResponseEntity<ErrorApiResponse> handleGameNotFoundError(GameNotFoundError e) {
        var errorResponse = ErrorApiResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        log.error("New Exception:", e.getMessage());

        return ResponseEntity.status(404).body(errorResponse);
    }

}
