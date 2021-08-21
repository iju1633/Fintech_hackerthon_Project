package com.example.hackerthonproject.dto;

import com.google.gson.annotations.SerializedName;


public class LocationDto {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getKinds() {
        return kinds;
    }

    public void setKinds(int kinds) {
        this.kinds = kinds;
    }

    public String getImg() {
        return img;
    }

    private int id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String explanation;
    private String img;


    private int kinds;
}
