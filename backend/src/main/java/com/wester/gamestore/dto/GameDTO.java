package com.wester.gamestore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.wester.gamestore.entities.Game;
import com.wester.gamestore.entities.Platform;

public class GameDTO {

    private Long id;
    private String name;
    private String releaseDate;
    private PublisherDTO publisher;

    private List<PlatformDTO> platforms = new ArrayList<>();

    public GameDTO(){
    }

    public GameDTO(Long id, String name, String releaseDate, PublisherDTO publisher) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
    }

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.releaseDate = entity.getReleaseDate();
        this.publisher = new PublisherDTO(entity.getPublisher());
    }

    public GameDTO(Game entity, Set<Platform> platforms) {
        this(entity);
        platforms.forEach(plat -> this.platforms.add(new PlatformDTO(plat)));
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

    public PublisherDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDTO publisher) {
        this.publisher = publisher;
    }

    public List<PlatformDTO> getPlatforms() {
        return platforms;
    }
}

