package com.example.hackerthonproject.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// http api interface 구현체
public class RetrofitClient {
    // 요청할 서버의 기본 url이다.
    private static final String BASE_URL = "http://10.0.2.2:8080/";

    // service
    // 싱글톤 패턴
    public static RetrofitAPI getApiService(){
        // json 응답을 객체로 변환해준다.
        return getInstance().create(RetrofitAPI.class);
    }

    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}