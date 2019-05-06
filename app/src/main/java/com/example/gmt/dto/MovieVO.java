package com.example.gmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieVO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("thumbnail")
    private String thumbnail;

    public MovieVO(){

    }
    public MovieVO(Long id, String name, String thumbnail) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "MovieVO{id : " + id + " name : " + name + " thumbnail : " + thumbnail + "}";
    }
}
