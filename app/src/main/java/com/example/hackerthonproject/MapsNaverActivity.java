package com.example.hackerthonproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hackerthonproject.Retrofit.RetrofitAPI;
import com.example.hackerthonproject.Retrofit.RetrofitCall;
import com.example.hackerthonproject.dto.UserDto;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MapsNaverActivity extends Activity implements OnMapReadyCallback, View.OnClickListener,Overlay.OnClickListener {

    MapView mapView;
    TextView test1;
    EditText mapInfo_MyPage;
    Button home, QR_Scan;
    TextView txt2;

    String QR_Scan_Message = "QR 코드가 스캔되었습니다.";
    String MyPage_Message = "마이페이지 정보가 조회되었습니다.";

    IntentIntegrator integrator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naver_activity_maps);

        mapView = findViewById(R.id.mapView);
        mapView.getMapAsync(this);
        txt2 = findViewById(R.id.textView2);

        RetrofitCall retrofit = new RetrofitCall();

        RetrofitAPI retrofitAPI = retrofit.getRetrofit().create(RetrofitAPI.class);

        Call<UserDto> call = retrofitAPI.getUser(2);

        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                //response 확인
                if (response.code() != 200) {
                    txt2.setText("Check");
                    return;
                }
                //Get the data into textView
                String jsony = "";
                jsony = "ID = " + response.body().getId() +
                        "Name = " + response.body().getName();
                txt2.append(jsony);
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {
                Log.wtf("err123", t);
                Log.d("IDIDID", "5시작");
            }
        });
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {

        Intent intent = getIntent();


        double latitude = intent.getDoubleExtra("latitude", 0);
        double longitude = intent.getDoubleExtra("longitude", 0);
        LocationOverlay locationOverlay = naverMap.getLocationOverlay();
        locationOverlay.setVisible(true);
        locationOverlay.setPosition(new LatLng(latitude, longitude));


        LatLng coord = new LatLng(37.5670135, 126.9783740);

        Toast.makeText(this,
                "위도: " + coord.latitude + ", 경도: " + coord.longitude,
                Toast.LENGTH_SHORT).show();
    }

    public void mOnClick(View v){
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onClick(@NonNull Overlay overlay) {
        if (overlay instanceof Marker) {

            test1.setText("클릭한 문자열");
            Toast.makeText(this.getApplicationContext(), "마커가 선택되었습니다", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public void home(View view){

    }

    public void QR_Scan(View view){

        // mapInfo_MyPage.setText(QR_Scan_Message);

        integrator = new IntentIntegrator(this);

        integrator.setPrompt("QR 코드를 사각형 안에 위치 시켜주세요");

        //QR 코드 인식 시에 삐- 소리가 나게 할것인지 여부
        integrator.setBeepEnabled(true);

        integrator.setBarcodeImageEnabled(true);

        integrator.setCaptureActivity(CaptureActivity.class);

        //스캐너 시작 메소드
        integrator.initiateScan();
    }

    public void myPage(View view){

        // mapInfo_MyPage.setText(MyPage_Message);

        Context mContext = getApplicationContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.activity_mypage, (ViewGroup) findViewById(R.id.popup));
        AlertDialog.Builder dialog = new AlertDialog.Builder(MapsNaverActivity.this);

        dialog.setTitle("MyPage");
        dialog.setView(layout);

        dialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                }
        });

        AlertDialog ad = dialog.create();
        ad.show();
    }

    @Override
    public void onClick(View v) {

    }
}
