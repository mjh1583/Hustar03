package com.example.exam_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }

    public void back(View v) {
        if(v.getId() == R.id.backBTN) {
            finish();
        }
        else if(v.getId() == R.id.button2) {
            // 1. Intent 메시지 객체 생성
            Intent moveINT = new Intent(SecondActivity.this, ThirdActivity.class);

            // 2. Intent 전송 ==> startActivity()
            startActivity(moveINT);
        }
    }
}