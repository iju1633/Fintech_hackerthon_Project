package com.example.hackerthonproject.Retrofit;

import com.example.hackerthonproject.dto.LocationDto;
import com.example.hackerthonproject.dto.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// 요청할 api들에 대한 명세들을 인터페이스에 기술한다.

public interface RetrofitAPI {
    // 회원 정보
//    @GET("/api/test/")
//    Call<Object> getUser();

    @GET("/api/test/{id}")
    Call<UserDto> getUser(@Path("id") int id);

    @GET("/location/all")
    Call<List<LocationDto> > getLocationList();


    // ResponseBody 자리는 어떤 타입으로 응답을 받을건지 적어두는 곳이다.
    // 회원가입
    // @POST("/api/test/")


//    @PUT
//    @DELETE

}