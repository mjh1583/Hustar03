package com.example.examlist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimpleList2 extends AppCompatActivity {
    // Member Variable ---------------------------------------------------------
    private final boolean           D = true;
    private final String            TAG = "DynamicList";

    private ListView                simpleList;

    // List 관련
    private ArrayList<HashMap<String, String>> list;
    private SimpleAdapter adapter;

    // Member Method - Activity's Override -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        init();

        if(D) Log.i(TAG, "onCreate() OK");
    }

    // Member Method - Custom --------------------------------------------------
    // App 초기화 메서드
    private void init() {
        simpleList = findViewById(R.id.simpleList);

        // List 데이터 준비
        list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Hong");
        map.put("area", "Daegu");
        list.add(map);

        // List 생성 및 관리 adapter
        adapter = new SimpleAdapter(SimpleList2.this,
                list,
                R.layout.list_item,
                new String[]{"name", "area"},
                new int[]{R.id.nameTXT, R.id.areaTXT});

        // ListView에 adapter 설정
        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleList2.this, "Click Item => " +
                        ((TextView)view.findViewById(R.id.areaTXT)).getText() +
                        " position : " + position + " id : " + id,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Member Method - XML's onClick -------------------------------------------
    public void onClick(View v) {

    }
}