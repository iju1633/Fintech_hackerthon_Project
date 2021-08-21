package com.example.hackerthonproject.dto;

import com.google.gson.annotations.SerializedName;

public class UserDto {
    public UserDto() {
    }

    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("name")
    private String name;
    @SerializedName("point")
    private int point;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
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

    public int getPoint() {

        return point;
    }

    public void setPoint(int point) {

        this.point = point;
    }

}