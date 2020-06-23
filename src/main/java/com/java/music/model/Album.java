package com.java.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ALBUM")
public class Album {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "title")
	private String title;
	
	@Column(name = "year_of_release")
	private String yearOfRelease;
	
	@Column(name="genres")
	private String genres;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	private Artist artist;
	
}
