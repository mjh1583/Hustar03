package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Viewer extends AppCompatActivity {

    private ImageView imageView;

    private int imageSrc[] = {R.drawable.cat0, R.drawable.cat1 ,R.drawable.cat2, R.drawable.cat3,
            R.drawable.cat4, R.drawable.cat5, R.drawable.cat6,
            R.drawable.cat7, R.drawable.cat8, R.drawable.cat9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);

        Intent viewer = getIntent();

        int src = viewer.getIntExtra("imageSrc", 0);
        imageView = findViewById(R.id.viewer);

        for(int i = 0; i <imageSrc.length; i++) {
            if(src == imageSrc[i]) {
                imageView.setImageResource(src);
            }
        }
    }

    public void onClick(View v) {
        finish();
    }
}