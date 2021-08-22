package com.example.hackerthonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        /* adapt data */
        productItems = new ArrayList<>();
        for(int i=1;i<=26;i++){

            productItems.add(new ProductItem(i+"번째 종목",i+"번째 가격",i+"번째 pcr", i+"번째 pcp", i+"번째 상승폭"));
        }
        myRecyclerAdapter.setFriendList(productItems);
    }
}