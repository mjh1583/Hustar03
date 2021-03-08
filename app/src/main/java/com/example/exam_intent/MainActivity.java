package com.example.exam_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // xml onClick's Method ------------------------------------------------------------------------
    public void onClick(View v) {
        // 화면 클릭(터치)하면 SecondActivity 전환하기

        // 1. Intent 메시지 객체 생성
        Intent moveINT = new Intent(MainActivity.this, SecondActivity.class);

        // 2. Intent 전송 ==> startActivity()
        startActivity(moveINT);
        
    }
}