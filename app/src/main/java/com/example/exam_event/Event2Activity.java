package com.example.exam_event;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Event2Activity extends AppCompatActivity {

    // Member Variable -----------------------------------------------------
    private final boolean   D = true;
    private final String    TAG = "ExamEvent";

    private Button          okBTN;
    private EditText        nameETXT;
    private InputMethodManager imm;

    // Member Method - Activity's Override --------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 설정
        setContentView(R.layout.event2_main);

        // 초기화
        init();

        if(D) Log.i(TAG, "onCreate()");
    }

    long initTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "KEY DOWN : " + keyCode);

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if(System.currentTimeMillis() - initTime > 3000) {
                    // back button을 누른 지 3초가 지났으면
                    Toast.makeText(Event2Activity.this, "종료하려면 한번 더 누르세요.", Toast.LENGTH_SHORT).show();

                    // 현재 시간 저장
                    initTime = System.currentTimeMillis();
                }
                else {
                    finish();
                }
                break;
            case KeyEvent.KEYCODE_HOME:
                break;
        }
        //return super.onKeyDown(keyCode, event);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "TOUCH DOWN ( " + event.getX() + ", " + event.getY() + " )");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "TOUCH MOVE ( " + event.getX() + ", " + event.getY() + " )");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "TOUCH UP ( " + event.getX() + ", " + event.getY() + " )");
                break;
        }
        //return super.onTouchEvent(event);
        return true;
    }

    // Member Method - Custom ---------------------------------------------
    // 초기화 메서드
    public void init() {
        // System 서비스 객체 가져오기
        imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        // View 객체 가져오기
        okBTN = findViewById(R.id.okBTN);
        nameETXT = findViewById(R.id.nameETXT);

        // View 이벤트 리스너 설정
        nameETXT.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i(TAG, "onEditorAction() actiondId : " + actionId);
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    imm.hideSoftInputFromWindow(nameETXT.getWindowToken(), 0);
                }
                return true;
            }
        });
    }

    // Member Method - XML onClick Method ---------------------------------
    public void click(View v) {
        // Softkeyboard 숨기기 설정
        imm.hideSoftInputFromWindow(nameETXT.getWindowToken(), 0);
    }
}