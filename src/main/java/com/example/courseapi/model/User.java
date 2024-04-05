package com.example.courseapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String imagePath;
    private String email;
    private String country;
    private String city;
    private String profession;
    private String phone;
    public User(){}
    public User(String username, String password, String name, String lastName, String imagePath,String email, String country, String city, String profession, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.imagePath = imagePath;
        this.email = email;
        this.country = country;
        this.city = city;
        this.profession = profession;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

