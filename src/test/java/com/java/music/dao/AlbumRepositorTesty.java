package com.java.music.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.java.music.model.Album;
import com.java.music.model.Artist;

@DataJpaTest
public class AlbumRepositorTesty {

	
	@Autowired
	AlbumRepository repository;

	@Test
	public void testRepository() {
		Album album = new Album();
		album.setTitle("Paulo");

		repository.save(album);
        List<Album> albums =repository.findAll();
        assertThat(albums.size(), is(1));
		assertThat(albums.get(0).getId(), is(1L));
	}
	
}
