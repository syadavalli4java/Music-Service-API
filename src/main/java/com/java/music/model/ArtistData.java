package com.java.music.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtistData {
	
	private Long id;
	private String name;
	
	public ArtistData(Artist artist) {
		this.id =  artist.getArtistId();
		this.name =  artist.getName();
	}
	
	public ArtistData(String name) {
		this.name = name;
	}
	
	public Artist convertToArtist() {
		Artist artist = new Artist();
		artist.setName(this.name);
		return artist;
				
	}
}
