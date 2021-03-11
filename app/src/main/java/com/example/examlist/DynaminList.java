package com.example.examlist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DynaminList extends AppCompatActivity {
    // Member Variable ---------------------------------------------------------
    private final boolean           D = true;
    private final String            TAG = "DynamicList";

    private ListView                dynamicLIST;
    private EditText                nameETXT;

    // List 관련
    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String>    adapter;

    // Member Method - Activity's Override -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_list);

        init();

        if(D) Log.i(TAG, "onCreate() OK");
    }

    // Member Method - Custom --------------------------------------------------
    // App 초기화 메서드
    private void init() {
        dynamicLIST = findViewById(R.id.dynamicLIST);
        nameETXT = findViewById(R.id.nameETXT);

        // 기본 데이터 삽입
        list.add("Sonny");

        // List 생성
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                list);

        // ListView에 List 설정
        dynamicLIST.setAdapter(adapter);

        // ListView Item 클릭 이벤트 설정
        dynamicLIST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DynaminList.this, "Click Item! => "+ ((TextView)view).getText() + " position : " + position + " id : " +id, Toast.LENGTH_SHORT).show();
                //((TextView)view).setText("Change Data");
            }
        });
    }

    public void onClick(View v) {
        if(v.getId() == R.id.addBTN) {
            if(nameETXT.getText().length() > 0) {
                list.add(nameETXT.getText().toString());

                // 어댑터 객체에 변경 내용 반영
                adapter.notifyDataSetChanged();
                nameETXT.setText("");
            }
            else {
                Toast.makeText(DynaminList.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}