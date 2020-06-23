package com.java.music.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.java.music.model.Artist;

import static org.hamcrest.Matchers.*;

@DataJpaTest
public class ArtistRepositoryTest {

	@Autowired
	ArtistRepository repository;

	@Test
	public void testRepository() {
		Artist artist = new Artist();
		artist.setName("Paulo");

		repository.save(artist);
        List<Artist> artists =repository.findAll();
        assertThat(artists.size(), is(1));
		assertThat(artists.get(0).getArtistId(), is(1L));
	}
}
