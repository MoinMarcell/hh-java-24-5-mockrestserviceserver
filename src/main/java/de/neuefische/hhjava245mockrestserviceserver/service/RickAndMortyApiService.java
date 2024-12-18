package de.neuefische.hhjava245mockrestserviceserver.service;

import de.neuefische.hhjava245mockrestserviceserver.dto.api.RickAndMortyApiCharacter;
import de.neuefische.hhjava245mockrestserviceserver.dto.api.RickAndMortyApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RickAndMortyApiService {

	private static final String BASE_URL = "https://rickandmortyapi.com/api";
	private final RestClient restClient;

	public RickAndMortyApiService(RestClient.Builder builder) {
		this.restClient = builder
				.baseUrl(BASE_URL)
				.build();
	}

	public RickAndMortyApiResponse fetchAllCharacters() {
		return restClient
				.get()
				.uri("/character")
				.retrieve()
				.body(RickAndMortyApiResponse.class);
	}

	public RickAndMortyApiResponse fetchAllCharacters(String page) {
		return restClient
				.get()
				.uri("/character/?page=" + page)
				.retrieve()
				.body(RickAndMortyApiResponse.class);
	}

	public RickAndMortyApiCharacter fetchSingleCharacterById(String id) {
		return restClient
				.get()
				.uri("/character/" + id)
				.retrieve()
				.body(RickAndMortyApiCharacter.class);
	}
}
