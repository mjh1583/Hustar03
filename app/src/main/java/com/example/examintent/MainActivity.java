package com.example.examintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // Member Variable -----------------------------------------------------------------------------
    private final boolean               D = true;
    private final String                TAG = "MainActivity";

    private ListView                    simpleLST;
    private TextView                    msgTXT;

    private ArrayAdapter<String>        adapter;
    private ArrayList<String>           arrayList = new ArrayList<>();

    // Member Method - Override --------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();

        if(D) Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case AppConstant.REQ_DATA_CODE:
                if(resultCode == RESULT_OK) {
                    if(D) Log.i(TAG, "RESULT DATA = " + data.getStringExtra(AppConstant.KEY_PHONE));
                }
                else {
                    Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(MainActivity.this, "Click => " + ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onItemClick()");

        Intent intent;

        switch (position) {
            case AppConstant.ITEM_GO:
                // GoActivity 전환
                intent = new Intent(MainActivity.this, GoAvtivity.class);
                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_WITH_DATA:
                // Primitive Data와 함께 전달
                intent = new Intent(MainActivity.this, GoAvtivity.class);
                intent.putExtra(AppConstant.KEY_NAME,"KIM");
                intent.putExtra(AppConstant.KEY_PHONE,"010-1234-5678");

                // Primitive Data List와 함께 전달
                intent = new Intent(MainActivity.this, GoAvtivity.class);

                ArrayList<String> names = new ArrayList<>();
                names.add("Hong");
                names.add("Choi");
                names.add("Park");
                names.add("Kwon");

                intent.putExtra(AppConstant.KEY_NAMES, names);

                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_WITH_OBJECT:
                // Custom Class Data 전달
                ArrayList<Person> persons = new ArrayList<>();
                persons.add(new Person("Tom", "F", 10));
                persons.add(new Person("Ghwa", "F", 35));
                persons.add(new Person("Jerry", "M", 14));

                intent = new Intent(MainActivity.this, GoObjectAvtivity.class);
                intent.putExtra(AppConstant.KEY_PERSONS, persons);
                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_BACK:
                // 다른 Activity 전환 후 결과 받아오기
                intent = new Intent(MainActivity.this, GoBackAvtivity.class);
                startActivityForResult(intent, AppConstant.REQ_DATA_CODE);
                break;
            default:
                break;
        }
    }

    // Member Method - Custom ----------------------------------------------------------------------
    public void init() {
        simpleLST = findViewById(R.id.simpleLST);

        arrayList.add(getResources().getString(R.string.go));
        arrayList.add(getResources().getString(R.string.go_with_data));
        arrayList.add(getResources().getString(R.string.go_with_object));
        arrayList.add(getResources().getString(R.string.go_back));

        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        simpleLST.setAdapter(adapter);
        // onItemClickListener
//        simpleLST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Click => " + ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//
//                switch (position) {
//                    case 0:
//                        // GoActivity 전환
//                        Intent intent = new Intent(MainActivity.this, GoAvtivity.class);
//                        startActivity(intent);
//                        break;
//                }
//
//            }
//        });
        simpleLST.setOnItemClickListener(this::onItemClick);
    }
}