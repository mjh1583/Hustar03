package com.example.examintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;


public class GoAvtivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------------------------
    private final boolean               D = true;
    private final String                TAG = "GoActivity";

    private TextView                    msgTXT;

    // Member Method - Override --------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go);

        if(D) Log.i(TAG, "onCreate()");

        init();
    }

    // Member Method - Custom ----------------------------------------------------------------------
    private void init() {
        // 현재 Activity 실행한 Intent 객체 가져오기
        Intent rxIntent = getIntent();
        //String rxData = rxIntent.getStringExtra(AppConstant.KEY_NAME);
        ArrayList<String> rxData = (ArrayList<String>) rxIntent.getSerializableExtra(AppConstant.KEY_NAMES);

        // View 객체 가져오기
        msgTXT = findViewById(R.id.msgTXT);

        //if(rxData != null) msgTXT.setText(rxData);
        if(rxData != null) {
            String data = "";

            // 향상된 for 문
            for(String str : rxData)
                data += str + "\n";

            msgTXT.setText(data);
        }

    }
}