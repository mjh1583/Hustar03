package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //사용자에게 보여지는 화면 설정
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.layout_linear);

    }

}