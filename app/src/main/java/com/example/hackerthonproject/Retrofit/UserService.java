package com.example.hackerthonproject.Retrofit;



import com.example.hackerthonproject.dto.LocationDto;
import com.example.hackerthonproject.dto.UserDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class UserService {
        public UserDto getUserDto(){
                int id = 1;
                UserDto userDto = new UserDto();
                Call<UserDto> getUser = RetrofitClient.getApiService().getUser(id);
                userDto = (UserDto) getUser;
                System.out.println(userDto.getId());
                System.out.println(userDto.getName());
                System.out.println(userDto.getEmail());
                System.out.println(userDto.getPassword());
                return userDto;
        }


}
