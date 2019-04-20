package com.example.gmt;

public class MovieVO {

    private Long id;
    private String name;
    private String thumbnail;

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
