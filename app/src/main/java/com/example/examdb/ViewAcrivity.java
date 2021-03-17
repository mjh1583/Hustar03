package com.example.examdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewAcrivity extends AppCompatActivity {

    private static final String TAG = "EXAM_DB";

    private ListView viewLST;
    private SimpleCursorAdapter adapter;

    private DBOpenHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_acrivity);

        init();
        Log.d(TAG, " => ViewActivity : onCreate()");
    }

    private void init() {
        Log.i(TAG, " => ViewActivity : init()");

        viewLST = findViewById(R.id.viewLST);
        dbHelper = new DBOpenHelper(this);

        // List Data
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DBInfo.TABLE_MESSAGE, null);

        // data < --- > layout ==> List item
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                new String[]{DBInfo.KEY_TITLE, DBInfo.KEY_CONTENT},
                new int[] {android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        // ListView <== List 설정
        viewLST.setAdapter(adapter);
    }
}