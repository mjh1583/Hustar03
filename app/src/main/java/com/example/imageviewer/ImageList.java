package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ImageList extends AppCompatActivity {

    // Member 변수
    // 이미지 뷰의 아이디를 담는 int 배열
    private int[] imageViews = {R.id.imageView, R.id.imageView1, R.id.imageView2, R.id.imageView3,
            R.id.imageView4, R.id.imageView5, R.id.imageView6,
            R.id.imageView7, R.id.imageView8, R.id.imageView9};

    // 이미지 소스(Drawable)의 아이디를 담는 int 배열
    private int imageSrc[] = {R.drawable.cat0, R.drawable.cat1 ,R.drawable.cat2, R.drawable.cat3,
            R.drawable.cat4, R.drawable.cat5, R.drawable.cat6,
            R.drawable.cat7, R.drawable.cat8, R.drawable.cat9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list);
    }

    // Member Method
    // 이미지 뷰를 클릭하면 해당 이미지를 전체화면으로 보여주는 액티비티로 화면 전환
    public void onClick(View v) {
        for(int i = 0; i <imageViews.length; i++) {
            if(v.getId() == imageViews[i]) {  // 이미지 뷰의 아이디를 찾아서 알맞는 이미지를 넘겨줌
                // 전체화면으로 전환하는 인텐트
                Intent viewer = new Intent(ImageList.this, Viewer.class);

                // 인텐트에 이미지 소스에 해당하는 아이디 정보를 담아 넘겨줌
                viewer.putExtra("imageSrc", imageSrc[i]);

                startActivity(viewer);
            }
        }
    }
}