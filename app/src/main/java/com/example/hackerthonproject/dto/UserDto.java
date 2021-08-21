package com.example.hackerthonproject.dto;

import com.google.gson.annotations.SerializedName;

public class UserDto {

    private int id;

    private String email;

    private String password;

    private String name;

    private int point;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

}