package com.example.exam_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;

    private Resources resources;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        imageView = findViewById(R.id.catIMG);
        button = findViewById(R.id.ch_img_btn);
        resources = this.getResources();
    }

    public void onClick(View v) {
        if(v.getId() == R.id.ch_img_btn) {
            int i = random.nextInt(5);

            switch (i) {
                case 0:
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.bird));
                    break;
                case 1:
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.cat));
                    break;
                case 2:
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.cat2));
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.dog);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.elk);
                    break;
            }
        }
    }
}