//package com.example.hackerthonproject;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//
//public class StartPageActivity extends Activity implements View.OnClickListener {
//
//    Button start;
//    ImageView logo;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_startpage);
//
//        start = findViewById(R.id.start);
//        logo = findViewById(R.id.logo);
//
//        start.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(StartPageActivity.this, MapsNaverActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
////    public void start(View view) {
////        Intent intent = new Intent(getApplicationContext(), MapsNaverActivity.class);
////        startActivity(intent);
////    }
//
//}
