package com.wester.gamestore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.wester.gamestore.entities.Game;
import com.wester.gamestore.entities.Platform;
import com.wester.gamestore.entities.Publisher;

public class GameDTO {

    private Long id;
    private String name;
    private String releaseDate;
    
    
    private List<PublisherDTO> publishers = new ArrayList<>();

    private List<PlatformDTO> platforms = new ArrayList<>();

    public GameDTO(){
    }

    public GameDTO(Long id, String name, String releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.releaseDate = entity.getReleaseDate();
        }

    public GameDTO(Game entity, Set<Platform> platforms, Set<Publisher> publishers) {
        this(entity);
        platforms.forEach(plat -> this.platforms.add(new PlatformDTO(plat)));
        publishers.forEach(pub -> this.publishers.add(new PublisherDTO(pub)));
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<PublisherDTO> getPublishers() {
		return publishers;
	}

	public List<PlatformDTO> getPlatforms() {
        return platforms;
    }
}

