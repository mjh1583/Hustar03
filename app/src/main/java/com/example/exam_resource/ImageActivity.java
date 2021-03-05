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

    private int imgResIds[] = {R.drawable.bird, R.drawable.cat, R.drawable.cat2, R.drawable.dog, R.drawable.elk};
    private int idx = 0;

    private Resources resources;
    //private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 설정
        setContentView(R.layout.image_layout);

        //화면에 존재하는 UI 요소 객체 가져오기
        imageView = findViewById(R.id.catIMG);

        // res 폴더의 xml 지원 접근 객체
        resources = this.getResources();
    }

    public void onClick(View v) {
        if(v.getId() == R.id.ch_img_btn) {
            // 클릭할 때마다 ImageView Image 변경
            imageView.setImageDrawable(resources.getDrawable(imgResIds[idx]));
            imageView.setImageResource(imgResIds[idx]);
            //idx = (idx == imgResIds.length - 1) ? 0 : ++idx;

            if(idx == (imgResIds.length-1))
                idx = 0;
            else
                idx++;
            /*int i = random.nextInt(5);

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
                    break;*/
        }
    }
}
