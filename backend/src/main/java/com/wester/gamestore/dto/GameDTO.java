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
    private String imgUrl;
	private Double price;
    
    private List<PublisherDTO> publishers = new ArrayList<>();

    private List<PlatformDTO> platforms = new ArrayList<>();

    public GameDTO(){
    }

    public GameDTO(Long id, String name, String releaseDate,String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.imgUrl = imgUrl;
		this.price = price;

    }

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.releaseDate = entity.getReleaseDate();
        this.imgUrl = entity.getImgUrl();
        this.price = entity.getPrice();
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
    
    public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


    public List<PublisherDTO> getPublishers() {
		return publishers;
	}

	public List<PlatformDTO> getPlatforms() {
        return platforms;
    }
}

