package com.example.hackerthonproject.Retrofit;

import com.example.hackerthonproject.dto.LocationDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class LocationService {

    Call<List<LocationDto>> getLocation = RetrofitClient.getApiService().getLocationList();
    List<LocationDto> locationDto = new ArrayList<LocationDto>();

    public List<LocationDto> getLocation(){
        try{
            locationDto = getLocation.execute().body();
            return locationDto;

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public String getName(int num){
        try{
            locationDto = getLocation.execute().body();
            return (locationDto.get(num).getName());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public Double getLatitude(int num){
        try{
            locationDto = getLocation.execute().body();
            return (Double.parseDouble(locationDto.get(num).getLatitude()));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public Double getLongitude(int num){
        try{
            locationDto = getLocation.execute().body();
            return (Double.parseDouble(locationDto.get(num).getLongitude()));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String getExplanation(int num){
        try{
            locationDto = getLocation.execute().body();
            return (locationDto.get(num).getExplanation());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
