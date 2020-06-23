package com.java.music.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.java.music.dao.ArtistRepository;
import com.java.music.dao.ArtistSpecification;
import com.java.music.model.Artist;
import com.java.music.model.ArtistData;

@Service
public class ArtistServiceImpl {

	public ArtistRepository artistRepository;

	@Autowired
	public ArtistServiceImpl(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	public List<ArtistData> getAllArtists(String searchTerm, int page, int limit) {
		
		Page<Artist> artists;
		 
		Pageable pageable = PageRequest.of(page, limit, Sort.by("name").ascending());
		
		if (searchTerm != null) {
			artists = artistRepository.findAll(ArtistSpecification.nameIsLike(searchTerm), pageable);
		} else {

		  artists = artistRepository.findAll(pageable);		
		}
		
		List<ArtistData> artistsData = artists.stream().map(a -> new ArtistData(a)).collect(Collectors.toList());
		return artistsData;
	}

	public ArtistData saveArtist(ArtistData artist) {
		Artist artist_saved = artistRepository.save(artist.convertToArtist());
		return new ArtistData(artist_saved);

	}

	public ArtistData saveArtist(Long id, ArtistData artistData) throws Exception {
		Artist artist = artistRepository.findById(id).orElseThrow(() -> new Exception("Artist not found with id" + id));
		artist.setName(artistData.getName());
		return new ArtistData(artistRepository.save(artist));
	}

}
