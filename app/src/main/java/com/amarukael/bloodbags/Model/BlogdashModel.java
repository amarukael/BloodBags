package com.amarukael.bloodbags.Model;

public class BlogdashModel {
    private String name, date, image_drawable;

    public BlogdashModel(String name, String date, String image_drawable) {
        this.name = name;
        this.date = date;
        this.image_drawable = image_drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(String image_drawable) {
        this.image_drawable = image_drawable;
    }
}
