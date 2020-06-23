package com.java.music.controller;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.java.music.model.Artist;
import com.java.music.model.ArtistData;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
//@DataJpaTest
public class ArtistControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldSaveArtist() throws Exception {

		ArtistData artistDataReq = new ArtistData("ARRehman");
		String base_url = "http://localhost:" + port + "/artists";

		ResponseEntity<ArtistData> album = this.restTemplate.postForEntity(base_url, artistDataReq, ArtistData.class);
		assertThat(album.getBody().getId(), Matchers.isA(Long.class));
		assertThat(album.getBody().getName(), Matchers.is("ARRehman"));
	}

	@Test
	public void shouldUpdateArtist() throws Exception {

		ArtistData artistDataReq = new ArtistData("ARRehman");
		String base_url = "http://localhost:" + port + "/artists";

		ResponseEntity<ArtistData> album = this.restTemplate.postForEntity(base_url, artistDataReq, ArtistData.class);
		assertThat(album.getBody().getId(), Matchers.isA(Long.class));

		ArtistData artistDataReqAgain = new ArtistData("Stephanie");
	    this.restTemplate.put(base_url + "/" +  album.getBody().getId(), artistDataReqAgain);
		
	    List<ArtistData> albumList = restTemplate.exchange(
				base_url + "?searchTerm=Stephanie", 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<ArtistData>>() {}).getBody();
		
		assertThat(albumList.size(), Matchers.is(1));
		assertThat(albumList.get(0).getName(), Matchers.is("Stephanie"));
		
	//	ArtistData artistDataReq = new ArtistData(,"ARRehman");
	}
	
	@Test
	public void shouldReturnArtist() throws Exception {

		createNewArtist("Nicola");
		
		String base_url = "http://localhost:" + port + "/artists";

		List<ArtistData> albumList = restTemplate.exchange(
				base_url, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<ArtistData>>() {}).getBody();
		
		assertThat(albumList.size(), Matchers.is(2));
		assertThat(albumList.get(0).getName(), Matchers.is("ARRehman"));
		assertThat(albumList.get(0).getId(), Matchers.isA(Long.class));
		
		
		createNewArtist("Stephens");
		List<ArtistData> albumList1 = restTemplate.exchange(
				base_url, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<ArtistData>>() {}).getBody();
		assertThat(albumList1.size(), Matchers.is(3));
		
	}

	private void createNewArtist(String artistName) {
		ArtistData artistDataReq = new ArtistData(artistName);
		String base_url = "http://localhost:" + port + "/artists";

		ResponseEntity<Artist> album = this.restTemplate.postForEntity(base_url, artistDataReq, Artist.class);
		
	}

}
