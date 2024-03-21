package com.example.courseapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String description;
    private String instructor;

    private String imageUrl;
    private String courseUrl;

    public Course() {}

    public Course(long id, String title, String description, String instructor, String imageUrl, String courseUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.imageUrl = imageUrl;
        this.courseUrl = courseUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", courseUrl='" + courseUrl + '\'' +
                '}';
    }
}
