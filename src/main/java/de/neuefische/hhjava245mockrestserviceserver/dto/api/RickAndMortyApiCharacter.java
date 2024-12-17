package de.neuefische.hhjava245mockrestserviceserver.dto.api;

public record RickAndMortyApiCharacter(
		int id,
		String name,
		String status,
		String species,
		String gender,
		String image
) {
}
