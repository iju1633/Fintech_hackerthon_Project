package com.example.hackerthonproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class PopupActivity extends Activity implements View.OnClickListener {

    Button level, Description_Level;
    ImageButton to_mainPage;
    TextView message, point, wallet, breakdown, profile, image, setting, settings, logOut;
    TextView userPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        // 등급와 등급별 혜택 버튼
        level = findViewById(R.id.level);
        Description_Level = findViewById(R.id.Description_Level);

        // id 매핑
        message = findViewById(R.id.message);
        point = findViewById(R.id.point);
        wallet = findViewById(R.id.wallet);
        breakdown = findViewById(R.id.breakdown);
        profile = findViewById(R.id.profile);
        image = findViewById(R.id.image);
        setting = findViewById(R.id.setting);
        settings = findViewById(R.id.settings);
        logOut = findViewById(R.id.logOut);
        userPoint = findViewById(R.id.userPoint);
        to_mainPage = findViewById(R.id.to_mainPage);

        to_mainPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PopupActivity.this, MapsNaverActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {}

}

