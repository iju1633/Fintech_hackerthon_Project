package com.example.hackerthonproject.Retrofit;

import com.example.hackerthonproject.dto.LocationDto;

import java.util.List;

import retrofit2.Call;

public class LocationController {

    Call<List<LocationDto>> getLocation = RetrofitClient.getApiService().getLocationList();
}
