package com.example.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Member Variable ---------------------------------------------------------
    private final boolean           D = true;
    private final String            TAG = "MainActivity";

    private ListView                dataLIST;

    // List 관련
    private String[]                arrDatas = {"AA", "BB", "CC", "DD", "EE"};
    private ArrayAdapter<String>    adapter;

    // Member Method - Activity's Override -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if(D) Log.i(TAG, "onCreate() OK");
    }

    // Member Method - Custom --------------------------------------------------
    // App 초기화 메서드
    private void init() {
        dataLIST = findViewById(R.id.dataLIST);

        //List 데이터 준비
        arrDatas = this.getResources().getStringArray(R.array.fruits);

        // List 생성
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                arrDatas);

        // ListView에 List 설정
        dataLIST.setAdapter(adapter);

        // ListView Item 클릭 이벤트 설정
        dataLIST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView dataTXT = ((TextView)view).findViewById(android.R.id.text1);
                dataTXT.setText("Change Text");

                Toast.makeText(MainActivity.this, "Click Item! => "+ ((TextView)view).getText() + " position : " + position + " id : " +id, Toast.LENGTH_SHORT).show();
                //((TextView)view).setText("Change Data");
            }
        });
    }
}