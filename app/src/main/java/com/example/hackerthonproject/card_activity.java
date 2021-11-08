package com.example.hackerthonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackerthonproject.Retrofit.RetrofitAPI;
import com.example.hackerthonproject.Retrofit.RetrofitCall;
import com.example.hackerthonproject.dto.ProductItem;
import com.example.hackerthonproject.dto.ReitsDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class card_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter myRecyclerAdapter;
    private ArrayList<ProductItem> productItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        /* initiate adapter */
        myRecyclerAdapter = new MyRecyclerAdapter();

        /* initiate recyclerview */
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));


        //////////////////////ReitsDto 받아옴////////////////////
        RetrofitCall retrofit = new RetrofitCall();
        RetrofitAPI retrofitAPI = retrofit.getRetrofit().create(RetrofitAPI.class);
        Call<ArrayList<ProductItem>> call = retrofitAPI.getReitsList();
        productItems = new ArrayList<>();
        call.enqueue(new Callback<ArrayList<ProductItem>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductItem>> call, Response<ArrayList<ProductItem>> response) {
                //response 확인
                if (response.code() != 200) {
                    return;
                }
                myRecyclerAdapter.setFriendList(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<ProductItem>> call, Throwable t) {
                Log.wtf("err123", t);
                Log.d("IDIDID", "5시작");
            }
        });
        ////////////////////////////////////////////

        /* adapt data */
        myRecyclerAdapter.setFriendList(productItems);
    }
}