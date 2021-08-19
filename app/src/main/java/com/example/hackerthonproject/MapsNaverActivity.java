package com.example.hackerthonproject;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

public class MapsNaverActivity extends Activity implements OnMapReadyCallback {
    private MapView mapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naver_activity_maps);

        mapView = findViewById(R.id.map_view);
        mapView.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude", 0);
        double longitude = intent.getDoubleExtra("longitude", 0);

        LocationOverlay locationOverlay = naverMap.getLocationOverlay();
        locationOverlay.setVisible(true);


        locationOverlay.setPosition(new LatLng(latitude, longitude));
        List<Marker> markers = new ArrayList<>();

        for(int i=0 ; i <10; i++){
            Marker marker = new Marker();
            marker.setPosition(new LatLng(latitude*(i*0.001), longitude*(i*0.001)));
            markers.add(marker);
            markers.get(i).setMap(naverMap);
        }

        Log.d("MapNaver", String.valueOf(markers)) ;



//        Marker marker = new Marker();
//        Marker marker2 = new Marker();
//        marker.setPosition(new LatLng(latitude, longitude));
//        marker2.setPosition(new LatLng(37.5670135, 126.9783740));
//        marker.setMap(naverMap);
//        marker2.setMap(naverMap);

    }

    public void mOnClick(View v){
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}
