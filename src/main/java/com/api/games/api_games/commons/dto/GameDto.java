package com.api.games.api_games.commons.dto;

public record GameDto(
        String name,
        String genre,
        String platform,
        String releaseDate) {
}