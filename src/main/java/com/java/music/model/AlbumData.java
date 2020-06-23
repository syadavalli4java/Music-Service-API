package com.java.music.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlbumData {

	public AlbumData(Album album) {
		this.id = album.getId();
		this.title = album.getTitle();
		this.yearOfRelease = album.getYearOfRelease();
		this.genres = album.getGenres();

	}

	private Long id;
	private String title;
	private String yearOfRelease;
	private String genres;

	public Album convertObjectAlbum() {
		Album album = new Album();

		album.setTitle(this.title);
		album.setYearOfRelease(this.yearOfRelease);
		album.setGenres(this.genres);
		return album;
	}

	public AlbumData(String title, String yearOfRelease, String genres) {
	
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.genres = genres;
	}

	public AlbumData() {
		// TODO Auto-generated constructor stub
	}

}
