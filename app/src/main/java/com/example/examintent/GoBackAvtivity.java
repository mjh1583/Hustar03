package com.example.examintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class GoBackAvtivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------------------------
    private final boolean               D = true;
    private final String                TAG = "GoBackActivity";

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
        msgTXT = findViewById(R.id.msgTXT);
        msgTXT.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // 결과 돌려주기
                if(D) Log.i(TAG, "onLongClick()");

                Intent intent = new Intent();
                intent.putExtra(AppConstant.KEY_PHONE, "010-1234-5678");
                setResult(RESULT_OK, intent);
                finish();
                return true;
            }
        });
    }
}