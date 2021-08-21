//package com.example.hackerthonproject.Retrofit;
//
//
//
//import com.example.hackerthonproject.dto.LocationDto;
//import com.example.hackerthonproject.dto.UserDto;
//
//import java.io.IOException;
//
//import retrofit2.Call;
//
//public class MainTest {
//
//    public static void main(String[] args){
//        // controller
//        int id = 1;
//        Call<UserDto> getUser = RetrofitClient.getApiService().getUser(id);
//        Call<LocationDto> getLocation = RetrofitClient.getApiService().getLocation();
//        System.out.println("asdf"+RetrofitClient.getApiService().getLocation().getClass().getName());
//
//        try {
////            LocationDto locationDto = new LocationDto();
////            locationDto = getLocation.execute().body();
////            System.out.println("locationDto = " + locationDto.getLatitude());
//            UserDto user = new UserDto();
//            user = getUser.execute().body();
//            System.out.println(user.getId());
//            System.out.println(user.getName());
//            System.out.println(user.getEmail());
//            System.out.println(user.getPassword());
//            System.out.println("git test");
//
//        }
//        catch (IOException ex){
//            ex.printStackTrace();
//        }
//    }
//}
