package com.example.navidrawer.model;

public class Post {

    private String date;
    private String Description;
    private String image;

    public Post() {
    }

    public Post(String date, String description, String image) {
        this.date = date;
        this.Description = description;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
