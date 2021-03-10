package com.example.exam_event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Member Variable -----------------------------------------------------
    private final boolean   D = true;
    private final String    TAG = "ExamEvent";

    private Button          leftBTN;
    private TextView        msgTXT;
    private CheckBox        checkBox;
    private RadioGroup      radioGroup;
    private RadioButton     redRBTN, blueRBTN;
    private ConstraintLayout conLay;

    // Member Method - Activity's Override --------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 설정
        setContentView(R.layout.activity_main);

        // 초기화
        init();

        if(D) Log.i(TAG, "onCreate()");
    }

    // Member Method - Custom ---------------------------------------------
    // 초기화 메서드
    private void init() {
        // View 객체 가져오기
        leftBTN = findViewById(R.id.leftBTN);
        msgTXT = findViewById(R.id.msgTXT);
        checkBox = findViewById(R.id.checkBox);
        redRBTN = findViewById(R.id.redRBTN);
        blueRBTN = findViewById(R.id.blueRBTN);
        radioGroup = findViewById(R.id.radioGroup);
        conLay = findViewById(R.id.conLay);

        // View 이벤트 리스너 설정
        leftBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "leftBTN - onClick()");
            }
        });

        msgTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "msgTXT - onClick()");
            }
        });

        leftBTN.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG, "leftBTN - Long~Long~Click");
                return false;
            }
        });

        // CheckBox의 check 여부에 따른 동작
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "checkbox - CheckedChange " + isChecked);

                conLay.setBackgroundColor( (isChecked) ? Color.CYAN : Color.WHITE);
//                conLay.setBackgroundColor(Color.rgb((new Random().nextInt() * 255) + 1,
//                        (new Random().nextInt() * 255) + 1,
//                        (new Random().nextInt() * 255) + 1));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i(TAG, "radioGroup - CheckedId : " +
                        ( (RadioButton)findViewById(checkedId) ).getText() );
            }
        });

        redRBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "radioButton - CheckedChange : " +
                        buttonView.getText() );
            }
        });
    }
}