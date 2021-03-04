package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);
    }

    public void clickFunc(View v) {
        /*if(v.getId() == R.id.oneBTN) {
            btn = findViewById(v.getId());
            btn.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.twoBTN) {
            btn = findViewById(v.getId());
            btn.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.threeBTN) {
            btn = findViewById(v.getId());
            btn.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.fourBTN) {
            btn = findViewById(v.getId());
            btn.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.fiveBTN) {
            btn = findViewById(v.getId());
            btn.setVisibility(View.INVISIBLE);
        }*/
        v.setVisibility(View.GONE);
    }
}