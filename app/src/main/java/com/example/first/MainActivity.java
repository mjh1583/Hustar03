
package com.example.first;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 멤버 변수 선언
    // -------------------------------------------------------
    // Debug -------------------------------------------------
    private final static String TAG = "MainActivity";  // Log 출력 시 구분자

    // UI ----------------------------------------------------
    private LinearLayout joinLAY;
    private LinearLayout change_bgcolor;
    private TextView textView;
    private TextView titleTXT;

    // Control -----------------------------------------------
    private Random random = new Random();

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
        //setContentView(R.layout.change_bgcolor);

        // 디버깅을 위한 로그 출력
        Log.i(TAG, "onCreate()");
        // 간단한 메시지 창 띄우기, 반드시 show() 해야 화면에 보임!!!
        Toast.makeText(MainActivity.this, "My App Create~~~", Toast.LENGTH_LONG).show();

        // UI 요소 객체 가져오기  -- join.xml
        joinLAY = (LinearLayout)findViewById(R.id.joinLAY);
        joinLAY.setBackgroundColor(Color.YELLOW);

        titleTXT = findViewById(R.id.titleTXT);
    }

    // onClick 속성 지원 Method -------------------------------------------
    // UI 요소 중 onClick 속성 설정한 경우 실행되는 메서드
   public void clickFuncJoin(View v) {
        if(v.getId() == R.id.cancelBTN) {
            Toast.makeText(MainActivity.this, "C A N C E L", Toast.LENGTH_SHORT).show();
            titleTXT.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.okBTN) {
            Toast.makeText(MainActivity.this, "OK Click!!", Toast.LENGTH_SHORT).show();
            joinLAY.setBackgroundColor(Color.rgb(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)));
            titleTXT.setVisibility(View.VISIBLE);
        }

    }  // join.xml의 클릭 메서드

    public void clickFunc(View v) {
        change_bgcolor = findViewById(R.id.bgColor);
        textView = findViewById(R.id.editText_changeBGC);
        
        if(v.getId() == R.id.red) {
            textView.setText("레드");
            change_bgcolor.setBackgroundColor(Color.RED);
        }
        else if(v.getId() == R.id.blue) {
            textView.setText("블루");
            change_bgcolor.setBackgroundColor(Color.BLUE);
        }
        else if(v.getId() == R.id.random_color) {
            textView.setText("랜덤");
            change_bgcolor.setBackgroundColor(Color.rgb((int)(Math.random() * 255) + 1,(int)(Math.random() * 255) + 1,(int)(Math.random() * 255) + 1));
        }
        else if(v.getId() == R.id.editText_changeBGC) {
            Log.i(TAG, "Title CLICK!");
            Toast.makeText(MainActivity.this, "배경화면 색 변경!!", Toast.LENGTH_SHORT).show();
            change_bgcolor.setBackgroundColor(Color.rgb((int)(Math.random() * 255) + 1,(int)(Math.random() * 255) + 1,(int)(Math.random() * 255) + 1));
        }
    } //change_bgcolor.xml의 버튼 클릭 메서드

}