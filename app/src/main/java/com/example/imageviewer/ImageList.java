package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ImageList extends AppCompatActivity {

    private int[] imageViews = {R.id.imageView, R.id.imageView1, R.id.imageView2, R.id.imageView3,
            R.id.imageView4, R.id.imageView5, R.id.imageView6,
            R.id.imageView7, R.id.imageView8, R.id.imageView9};

    private int imageSrc[] = {R.drawable.cat0, R.drawable.cat1 ,R.drawable.cat2, R.drawable.cat3,
            R.drawable.cat4, R.drawable.cat5, R.drawable.cat6,
            R.drawable.cat7, R.drawable.cat8, R.drawable.cat9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list);
    }

    public void onClick(View v) {
        for(int i = 0; i <imageViews.length; i++) {
            if(v.getId() == imageViews[i]) {
                Intent viewer = new Intent(ImageList.this, Viewer.class);

                viewer.putExtra("imageSrc", imageSrc[i]);

                startActivity(viewer);
            }
        }
    }
}