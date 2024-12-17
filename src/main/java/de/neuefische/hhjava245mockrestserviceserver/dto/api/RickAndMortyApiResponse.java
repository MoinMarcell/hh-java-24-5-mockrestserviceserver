package de.neuefische.hhjava245mockrestserviceserver.dto.api;

import de.neuefische.hhjava245mockrestserviceserver.embedabble.RickAndMortyApiInfo;

import java.util.List;

public record RickAndMortyApiResponse(
		RickAndMortyApiInfo info,
		List<RickAndMortyApiCharacter> results
) {
}
