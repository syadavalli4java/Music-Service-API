package com.java.music.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.ws.Response;

import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.java.music.dao.AlbumRepository;
import com.java.music.dao.ArtistRepository;
import com.java.music.model.Album;
import com.java.music.model.AlbumData;
import com.java.music.model.AlbumDetails;
import com.java.music.model.Artist;
import com.java.music.model.Results;

@Service
public class AlbumServiceImpl {

	private AlbumRepository albumRepository;

	private ArtistRepository artistRepository;

	private RestTemplate restTemplate;

	private Gson gson;

	@Autowired
	public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository,
			RestTemplate restTemplate, Gson gson) {
		this.albumRepository = albumRepository;
		this.artistRepository = artistRepository;
		this.restTemplate = restTemplate;
		this.gson = gson;
	}
	/*
	 * @Override public List<AlbumData> getAlbums() { List<Album> albums =
	 * albumRepository.findAll(); return albums.stream().map(a -> new
	 * AlbumData(a)).collect(Collectors.toList()); }
	 */

	public AlbumData saveAlbum(Long id, AlbumData albumData) throws Exception {

		Artist artist = artistRepository.findById(id)
				.orElseThrow(() -> new Exception("No artist exist with id: " + id));
		Album album = albumData.convertObjectAlbum();
		album.setArtist(artist);
		return new AlbumData(albumRepository.save(album));
	}

	public List<AlbumData> getAlbums(Long id) {
		// TODO Auto-generated method stub
		List<Album> album = albumRepository.fetchAlbums(id);
		List<AlbumData> albumData = album.stream().map(a -> new AlbumData(a)).collect(Collectors.toList());
		return albumData;
	}

	public AlbumData saveAlbum(Long artistId, Long albumId, AlbumData albumData) throws Exception {
		Artist artist = artistRepository.findById(artistId)
				.orElseThrow(() -> new Exception("No artist exist with id: " + artistId));

		Album album = albumRepository.findById(albumId)
				.orElseThrow(() -> new Exception("No album exist with id: " + albumId));

		album.setTitle(albumData.getTitle());
		album.setGenres(albumData.getGenres());
		album.setYearOfRelease(albumData.getGenres());
		return new AlbumData(albumRepository.save(album));
	}

	public AlbumData getAlbumById(Long artistId, Long albumId) {

		String url = "https://api.discogs.com/database/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("q", "nirvana")
				.queryParam("type", "master").queryParam("artist", "nirvana").queryParam("format", "album");
		// .queryParam("title", "Nevermind Smells Like In Utero");
		String uriBuilder = builder.build().encode().toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.set("Authorization",
				"Discogs key=" + "FJCGAwGzzotZqPbtkaaE" + ", secret=" + "VZGuhOkjckwaXJJeozjaCHGQMagoyEQP");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		entity = restTemplate.exchange(uriBuilder, HttpMethod.GET, entity, String.class);

		AlbumDetails resposne = gson.fromJson(entity.getBody(), AlbumDetails.class);

		AlbumData data = new AlbumData();

		for (Results result : resposne.getResults()) {
			if (result.getTitle().equalsIgnoreCase("Nirvana - Nevermind Smells Like In Utero")) {
				data.setTitle(result.getTitle());
				data.setYearOfRelease("1991");
				data.setId(Long.valueOf(result.getId()));
			}
		}
		
		return data;

	}

}
