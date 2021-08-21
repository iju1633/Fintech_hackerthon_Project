package com.example.hackerthonproject.Retrofit;

import com.example.hackerthonproject.dto.LocationDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class LocationService {

    Call<List<LocationDto>> getLocation = RetrofitClient.getApiService().getLocationList();
    List<LocationDto> locationDto = new ArrayList<LocationDto>();

    public String getAddress(){
        try{
            locationDto = getLocation.execute().body();
            System.out.println("getLocation = " + getLocation);

            System.out.println("locationDto = " + locationDto.get(0).getAddress());
            return (locationDto.get(0).getAddress());
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

}
