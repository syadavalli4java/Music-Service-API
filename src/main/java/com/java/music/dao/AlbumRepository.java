package com.java.music.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.java.music.model.Album;
import com.java.music.model.Artist;

@Repository
public interface AlbumRepository
		extends JpaRepository<Album, Long>, JpaSpecificationExecutor<Artist>, PagingAndSortingRepository<Album, Long> {

	@Query(value = "Select * FROM ALBUM a  WHERE a.artist_id = ?1", nativeQuery = true)
	List<Album> fetchAlbums(Long artistId);
}
