package com.example.first;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 멤버 변수 선언 -------------------------------------------------------
    private final static String TAG = "MainActivity";  // Log 출력 시 구분자

    // ---------------------------------------------------------------------
    // 멤버 메서드
    // ---------------------------------------------------------------------
    // AppCompatActivity's method ------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 사용자에게 보여지는 화면 설정
        // setContentView(R.layout.activity_main);
        // setContentView(R.layout.layout_linear);
        setContentView(R.layout.join);

        // 디버깅을 위한 로그 출력
        Log.i(TAG, "onCreate()");
        // 간단한 메시지 창 띄우기, 반드시 show() 해야 화면에 보임!!!
        Toast.makeText(MainActivity.this, "My App Create~~~", Toast.LENGTH_LONG).show();

    }

    // onClick 속성 지원 Method -------------------------------------------
    // UI 요소 중 onClick 속성 설정한 경우 실행되는 메서드
    public void clickFunc(View v) {

        if(v.getId() == R.id.cancelBTN)
            Toast.makeText(MainActivity.this, "C A N C E L", Toast.LENGTH_SHORT).show();
        else if(v.getId() == R.id.okBTN)
            Toast.makeText(MainActivity.this, "OK Click!!", Toast.LENGTH_SHORT).show();

    }

}