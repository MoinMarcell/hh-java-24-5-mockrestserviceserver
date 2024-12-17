package de.neuefische.hhjava245mockrestserviceserver.controller;

import de.neuefische.hhjava245mockrestserviceserver.dto.RickAndMortyCharacter;
import de.neuefische.hhjava245mockrestserviceserver.service.RickAndMortyCharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class RickAndMortyCharacterController {

	private final RickAndMortyCharacterService rickAndMortyCharacterService;

	public RickAndMortyCharacterController(RickAndMortyCharacterService rickAndMortyCharacterService) {
		this.rickAndMortyCharacterService = rickAndMortyCharacterService;
	}

	@GetMapping
	public List<RickAndMortyCharacter> getAllCharacters(@RequestParam(required = false) String page) {
		if (page == null) {
			return rickAndMortyCharacterService.getAllCharacters();
		} else {
			return rickAndMortyCharacterService.getAllCharacters(page);
		}
	}

	@GetMapping("/{id}")
	public RickAndMortyCharacter getCharacterById(@PathVariable("id") String id) {
		return rickAndMortyCharacterService.getCharacterById(id);
	}

}
