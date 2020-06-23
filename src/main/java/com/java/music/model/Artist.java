package com.java.music.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ARTIST")
public class Artist {

	@Id
	@Column(name = "artist_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistId;

	@Column(name = "Name")
	private String name;

	@OneToMany(mappedBy = "artist")
	private List<Album> albums;
}
