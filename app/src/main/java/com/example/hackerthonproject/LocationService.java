package com.example.hackerthonproject;

import android.location.Location;
import android.util.Log;

import com.example.hackerthonproject.Retrofit.RetrofitAPI;
import com.example.hackerthonproject.Retrofit.RetrofitCall;
import com.example.hackerthonproject.dto.LocationDto;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationService {

    public List<LocationDto> getLocationList(){
        RetrofitCall retrofit = new RetrofitCall();

        RetrofitAPI retrofitAPI = retrofit.getRetrofit().create(RetrofitAPI.class);

        Call<List<LocationDto>> call = retrofitAPI.getLocationList();

        List<LocationDto> locationsList = new ArrayList<LocationDto>();

        call.enqueue(new Callback<List<LocationDto>>() {
            @Override
            public void onResponse(Call<List<LocationDto>> call, Response<List<LocationDto>> response) {
                //response 확인
                if (response.code() != 200) {
                    return;
                }
                for(int i = 0; i < response.body().size(); i++){
                    locationsList.add(response.body().get(i));
                    Log.d("IDIDID2",locationsList.get(i).getName());
                    System.out.println(locationsList.get(i).getName());
                }
                Log.d("IDIDID", response.body().get(0).getAddress());
            }

            @Override
            public void onFailure(Call<List<LocationDto>> call, Throwable t) {
                Log.wtf("err123", t);
                Log.d("IDIDID", "5시작");
                System.out.println("Tlqkf1");
            }
        });
//        Log.d("IDIDID2132", locationsList.get(0).getAddress());

        return locationsList;
    }
}
