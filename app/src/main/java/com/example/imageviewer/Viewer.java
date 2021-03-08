package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Viewer extends AppCompatActivity {

    // Member 변수
    // 전체화면으로 보여줄 이미지뷰
    private ImageView imageView;

    // 이미지 뷰에 들어갈 이미지의 소스 배열
    private int imageSrc[] = {R.drawable.cat0, R.drawable.cat1 ,R.drawable.cat2, R.drawable.cat3,
            R.drawable.cat4, R.drawable.cat5, R.drawable.cat6,
            R.drawable.cat7, R.drawable.cat8, R.drawable.cat9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);

        // 앞의 ImageList 액티비티에서 넘겨준 인텐트의 정보를 받을 인텐트
        Intent viewer = getIntent();

        // 이미지 소스를 int 형으로 받고 값이 없을 시 기본값은 0
        int src = viewer.getIntExtra("imageSrc", 0);
        // 이미지 뷰 초기화
        imageView = findViewById(R.id.viewer);

        for(int i = 0; i <imageSrc.length; i++) {
            if(src == imageSrc[i]) {
                // 받은 이미지 소스를 찾아서 이미지 뷰에 할당
                imageView.setImageResource(src);
            }
        }
    }

    // 화면을 터치하면 전체화면 사진을 보여주는 액티비티를 종료하고 이전 화면으로 돌아감
    public void onClick(View v) {
        finish();
    }
}