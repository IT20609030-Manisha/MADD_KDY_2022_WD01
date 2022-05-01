package com.example.navidrawer.model;

public class Post {

    private String date;
    private String description;
    private String image;

    public Post() {
    }

    public Post(String date, String description, String image) {
        this.date = date;
        this.description = description;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
