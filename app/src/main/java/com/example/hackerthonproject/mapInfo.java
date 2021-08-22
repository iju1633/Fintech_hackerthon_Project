package com.example.hackerthonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class mapInfo extends AppCompatActivity {

    TextView titleView;
    TextView addressView;
    TextView infoView;
    ImageView imgView;
    TextView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_info3);


//        intent.putExtra("name", markerInfo.get(4).getName());
//        intent.putExtra("address", markerInfo.get(4).getAddress());
//        intent.putExtra("info", markerInfo.get(4).getExplanation());
//        intent.putExtra("img", markerInfo.get(4).getImg());

        Intent intent = getIntent();

        String title = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String info = intent.getStringExtra("info");
        String img = intent.getStringExtra("img");

        //레이아웃
        titleView = findViewById(R.id.titleView);
//        addressView = findViewById(R.id.)
        infoView = findViewById(R.id.infoView);
        imgView = findViewById(R.id.imageView);
        pointView = findViewById(R.id.pointView);
        ///
        titleView.setText(title);
        infoView.setText(info);

        new DownloadFilesTask().execute(img);

    }
    private class DownloadFilesTask extends AsyncTask<String,Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {
                String img_url = strings[0]; //url of the image
                URL url = new URL(img_url);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // doInBackground 에서 받아온 total 값 사용 장소
            imgView.setImageBitmap(result);
        }
    }
}