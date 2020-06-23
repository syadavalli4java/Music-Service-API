package com.java.music.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.java.music.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>,JpaSpecificationExecutor<Artist>, PagingAndSortingRepository<Artist, Long> {

	/*
	 * List<Artist> findAllByOrderByNameAsc(); List<Artist>
	 * findAllByOrderByNameAsc(Specification<Artist> specification);
	 */
}
