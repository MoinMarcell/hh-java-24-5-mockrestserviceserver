package de.neuefische.hhjava245mockrestserviceserver.dto;

public record RickAndMortyCharacter(
		int id,
		String name,
		String status,
		String species,
		String gender,
		String image
) {
}
