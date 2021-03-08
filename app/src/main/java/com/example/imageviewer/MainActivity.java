package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 화면을 클릭(터치)하면 이미지 리스트로 넘어감 == 인트로 화면
    public void onClick(View v) {
        Intent intro = new Intent(MainActivity.this, ImageList.class);

        startActivity(intro);
    }

}