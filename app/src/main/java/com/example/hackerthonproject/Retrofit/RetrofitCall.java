package com.example.hackerthonproject.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://221.168.38.224:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
