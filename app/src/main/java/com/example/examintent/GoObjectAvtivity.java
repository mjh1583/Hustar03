package com.example.examintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class GoObjectAvtivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------------------------
    private final boolean               D = true;
    private final String                TAG = "GoObjectActivity";

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

        ArrayList<Person> rxData = rxIntent.getParcelableArrayListExtra(AppConstant.KEY_PERSONS);

        // View 객체 가져오기
        msgTXT = findViewById(R.id.msgTXT);

        if(rxData != null) {
            String data = "";
            for(int i = 0; i < rxData.size(); i++)
                data += rxData.get(i).showInfo() + "\n";
            Log.i(TAG, data);
            msgTXT.setText(data);
        }
    }
}