package com.java.music.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.music.model.Album;
import com.java.music.model.AlbumData;
import com.java.music.model.ArtistData;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AlbumControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldSaveAlbums() throws Exception {
		
		createArtist();
		AlbumData albumDataRequest = new AlbumData("frozen","1988","hiphop");
		String base_url = "http://localhost:" + port + "/artists/1/albums";
		
		ResponseEntity<AlbumData> album= this.restTemplate.postForEntity(base_url, albumDataRequest,AlbumData.class);
		assertThat(album.getBody().getTitle(),Matchers.is("frozen"));
	}
	
	private void createArtist() {
		ArtistData artistDataReq = new ArtistData("ARRehman");
		String base_url = "http://localhost:" + port + "/artists";

		ResponseEntity<ArtistData> album = this.restTemplate.postForEntity(base_url, artistDataReq, ArtistData.class);
		
	}

	@Test
	public void shouldReturnAlbums() throws Exception {
		
		 String base_url = "http://localhost:" + port + "/artists/1/albums";
		
		List<AlbumData> albumList = this.restTemplate.getForObject(base_url, List.class);
		assertThat(albumList.size(),Matchers.is(0));
	}
	
	
}
