package com.example.hackerthonproject.Retrofit;

import com.example.hackerthonproject.dto.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TestService {
    @GET("/api/test/")
    Call<Object> getTest();

    @GET("/api/test/")
    Call<List<UserDto>> getUser(@Query("id") String id);
}