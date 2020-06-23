package com.java.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.music.model.ArtistData;
import com.java.music.service.ArtistServiceImpl;

@RestController
public class ArtistController {

	public ArtistServiceImpl artistService;

	public ArtistController(ArtistServiceImpl artistService) {
		this.artistService = artistService;
	}

	@GetMapping(value = "/artists")
	public List<ArtistData> getArtists(@RequestParam(required = false) String searchTerm,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) {
		return artistService.getAllArtists(searchTerm, page, limit);
	}

	@PostMapping(value = "/artists")
	public ArtistData createArtists(@RequestBody ArtistData artistData) {
		return artistService.saveArtist(artistData);
	}

	@PutMapping(value = "/artists/{artistId}")
	public ArtistData updateArtist(@PathVariable("artistId") Long id, @RequestBody ArtistData artistData)
			throws Exception {
		return artistService.saveArtist(id, artistData);
	}
}