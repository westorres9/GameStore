package com.wester.gamestore.dto;

import com.wester.gamestore.entities.Publisher;

public class PublisherDTO {
	
    private Long id;
    private String name;

    public PublisherDTO(){
    }

    public PublisherDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublisherDTO(Publisher entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
}

