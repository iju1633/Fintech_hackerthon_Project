package com.example.hackerthonproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hackerthonproject.Retrofit.UserService;


public class PopupActivity extends Activity implements View.OnClickListener {

    Button myPage, level, Description_Level;
    ImageButton imageButton;
    TextView message, point, wallet, breakdown, profile, image, phoneNum, setting, settings, logOut;
    TextView userPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        myPage = (Button) findViewById(R.id.myPage);

        myPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                startActivity(intent);


                UserService userService = new UserService();
                System.out.println(userService.getUserDto());
            }
        });

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
        phoneNum = findViewById(R.id.phoneNum);
        setting = findViewById(R.id.setting);
        settings = findViewById(R.id.settings);
        logOut = findViewById(R.id.logOut);
        userPoint = findViewById(R.id.userPoint);



//        popupWindow();

//        // setText 테스트
//        findViewById(R.id.point).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        point.setText(info());
//                    }
//                }
//        );

        getWindow().setBackgroundDrawableResource(android.R.color.transparent); // 왜 안되는 거니..
    }

    public void onClick(View view) {

        Button.OnClickListener t = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = (TextView) findViewById(R.id.point);
                point = (Button)findViewById(v.getId());

                txt.setText(info());

            }
        };

        if (view == myPage) { // view가 alert 이면 팝업실행 즉 버튼을 누르면 팝업창이 뜨는 조건

            Context mContext = getApplicationContext();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            //R.layout.dialog는 xml 파일명이고  R.id.popup은 보여줄 레이아웃 아이디
            View layout = inflater.inflate(R.layout.activity_mypage, (ViewGroup) findViewById(R.id.popup));
            AlertDialog.Builder aDialog = new AlertDialog.Builder(PopupActivity.this);

            //그냥 닫기버튼을 위한 부분
            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int useless) {
                }
            });


        }

    }

    public String info() {
        return "제발 되라";
    }

//    private void popupWindow() {
//        try {
//            Context mContext = getApplicationContext();
//            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
//            View layout = inflater.inflate(R.layout.activity_mypage,
//                    (ViewGroup) findViewById(R.id.popup));
//            PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.activity_mypage,
//                    null, false), 480, 800, true);
//
//            point = (TextView) layout
//                    .findViewById(R.id.point);
//            point.setText("Recording"); //Update the TextView
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

