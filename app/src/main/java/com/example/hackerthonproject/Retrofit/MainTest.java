package com.example.hackerthonproject.Retrofit;



import com.example.hackerthonproject.dto.LocationDto;
import com.example.hackerthonproject.dto.UserDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class MainTest {

    public static void main(String[] args){
        // controller
        int id = 1;
        Call<UserDto> getUser = RetrofitClient.getApiService().getUser(id);
        Call<List<LocationDto>> getLocation = RetrofitClient.getApiService().getLocationList();

        LocationService locationService = new LocationService();

        System.out.println(locationService.getAddress());

//            List<LocationDto> locationDto = new ArrayList<LocationDto>();
//            locationDto = getLocation.execute().body();
//
//            System.out.println("locationDto = " + locationDto.get(0).getAddress());
//
//            UserDto user = new UserDto();
//            user = getUser.execute().body();
//            System.out.println(user.getId());
//            System.out.println(user.getName());
//            System.out.println(user.getEmail());
//            System.out.println(user.getPassword());
//            System.out.println("git test");


    }
}
