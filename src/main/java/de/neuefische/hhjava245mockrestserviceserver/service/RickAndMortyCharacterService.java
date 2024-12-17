package de.neuefische.hhjava245mockrestserviceserver.service;

import de.neuefische.hhjava245mockrestserviceserver.dto.RickAndMortyCharacter;
import de.neuefische.hhjava245mockrestserviceserver.dto.api.RickAndMortyApiCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RickAndMortyCharacterService {

	private final RickAndMortyApiService rickAndMortyApiService;

	public RickAndMortyCharacterService(RickAndMortyApiService rickAndMortyApiService) {
		this.rickAndMortyApiService = rickAndMortyApiService;
	}

	public List<RickAndMortyCharacter> getAllCharacters() {
		return rickAndMortyApiService
				.fetchAllCharacters()
				.results()
				.stream()
				.map(character -> new RickAndMortyCharacter(
						character.id(),
						character.name(),
						character.status(),
						character.species(),
						character.gender(),
						character.image()))
				.toList();
	}

	public List<RickAndMortyCharacter> getAllCharacters(String page) {
		return rickAndMortyApiService
				.fetchAllCharacters(page)
				.results()
				.stream()
				.map(character -> new RickAndMortyCharacter(
						character.id(),
						character.name(),
						character.status(),
						character.species(),
						character.gender(),
						character.image()))
				.toList();
	}

	public RickAndMortyCharacter getCharacterById(String id) {
		RickAndMortyApiCharacter character = rickAndMortyApiService.fetchSingleCharacterById(id);
		return new RickAndMortyCharacter(
				character.id(),
				character.name(),
				character.status(),
				character.species(),
				character.gender(),
				character.image()
		);
	}

}
