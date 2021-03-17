package com.example.examdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------------------------
    private static final String TAG = "EXAM_DB";

    private DBOpenHelper dbHelper;
    private SQLiteDatabase db;

    private EditText titleETXT;
    private EditText messageETXT;

    private Button addBTN;
    private Button viewBTN;

    private Intent intent;
    // Member Method - Override --------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Log.i(TAG, "=> MainActivity : onCreate()");
    }

    // Member Method - Custom ----------------------------------------------------------------------
    private void init() {
        Log.i(TAG, "=> MainActivity : init()");
        titleETXT = findViewById(R.id.titleETXT);
        messageETXT = findViewById(R.id.messageETXT);

        addBTN = findViewById(R.id.addBTN);
        viewBTN = findViewById(R.id.viewBTN);

        // DB 생성
        dbHelper = new DBOpenHelper(MainActivity.this);
    }

    private void startViewActivity() {
        intent = new Intent(MainActivity.this, ViewAcrivity.class);
        startActivity(intent);
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private int getDataCount() {
        // select * from message_tbl;
        Cursor cursor = db.rawQuery("select * from " + DBInfo.TABLE_MESSAGE, null);

        return cursor.getCount();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addBTN:
                if(titleETXT.getText().length() > 0 && messageETXT.getText().length() > 0) {
                    // 1. DB Open
                    db = dbHelper.getWritableDatabase();

                    // 2. DB Write => Insert
                    ContentValues newData = new ContentValues();
                    newData.put(DBInfo.KEY_TITLE, titleETXT.getText().toString());
                    newData.put(DBInfo.KEY_CONTENT, messageETXT.getText().toString());
                    db.insert(DBInfo.TABLE_MESSAGE, null, newData);
                    Log.i(TAG, "=> MainActivity : addBTN : DB ROW COUNT : " + getDataCount());
                    // 3. DB Close
                    db.close();
                }
                else {
                    makeToast("제목과 메세지를 모두 입력하세요");
                }
                break;
            case R.id.viewBTN:
                startViewActivity();
                break;
        }
    }
}