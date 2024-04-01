package com.example.courseapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Speaker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String imageUrl;
    private String name;
    private String title;
    private String biography;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
}
