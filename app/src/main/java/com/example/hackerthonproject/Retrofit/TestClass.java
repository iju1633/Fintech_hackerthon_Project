package com.example.hackerthonproject.Retrofit;

import com.example.hackerthonproject.LocationService;

public class TestClass {
    public static void main(String[] args) {
        LocationService locationService = new LocationService();

        System.out.println("locationService.getLocationList() = " + locationService.getLocationList());

    }
}
