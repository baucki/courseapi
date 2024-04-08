package com.example.courseapi.model.requests;

public class ChangePersonalInformationRequest {

    private String username;
    private String name;
    private String lastName;
    private String email;
    private String country;
    private String city;
    private String phone;
    private String profession;
    public ChangePersonalInformationRequest() {}
    public ChangePersonalInformationRequest(String username, String name, String lastName, String email, String country, String city, String phone, String profession) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.profession = profession;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfession() {
        return profession;
    }


}
