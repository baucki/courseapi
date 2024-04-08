package com.example.courseapi.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Feedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String rating;
    private String description;
    @ManyToOne
    private Course course;

    public Feedback() {}

    public Feedback(long id, String rating, String description, Course course) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
