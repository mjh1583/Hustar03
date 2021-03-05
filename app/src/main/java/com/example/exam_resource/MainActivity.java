package com.example.exam_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Member Variable ------------------------------------------------------------------
    private final String TAG = "MainActivity";

    private LinearLayout linearLAY;
    private TextView msgTXT;
    private EditText msgETXT;

    private Resources appRes;  // xml res 자원 접근 객체

    // Member Method - AppCompactActivity's override ------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 객체 변수 초기화
        linearLAY = findViewById(R.id.linearLAY);
        msgTXT = findViewById(R.id.msgTXT);
        msgETXT = findViewById(R.id.msgETXT);

        appRes = this.getResources();
    }

    // Member Method - xml onclick 처리 메서드 --------------------------------------------
    public void onClick(View v) {
        // 클릭한 UI 요소 객체가 인자 v에 담겨져 옴
        if(v.getId() == R.id.linearLAY) {
            //전체 화면인 LinearLayout을 클릭 했을 경우 처리
            msgTXT.setTextColor(Color.RED);
            msgTXT.setTextSize(30);
            String curText = msgTXT.getText().toString();

            Log.i(TAG, "curText => " + curText);

            //smsgTXT.setText("Happy New Year");
            // 입력된 메시지 읽어오기
            String newMsg = msgETXT.getText().toString();

            // 입력 여부에 따라서 TextView 출력
            if(newMsg.length() > 0)
                msgTXT.setText(newMsg);
            else
                //msgTXT.setText("Nothing");
                msgTXT.setText(appRes.getString(R.string.nothing));
        }
    }
}