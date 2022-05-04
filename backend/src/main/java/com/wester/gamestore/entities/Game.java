package com.wester.gamestore.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game {
	
	private Long id;
	private String name;
	private String releaseDate;
	private Publisher publisher;
	
	private Set<Platform> platforms = new HashSet<>();
	
	public Game() {
	}
	
	public Game(Long id, String name, String releaseDate, Publisher publisher) {
		super();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Platform> getPlatforms() {
		return platforms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
	
}
