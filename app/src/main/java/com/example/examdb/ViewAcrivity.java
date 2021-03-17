package com.example.examdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewAcrivity extends AppCompatActivity {

    private static final String TAG = "EXAM_DB";

    private ListView viewLST;
    private SimpleCursorAdapter adapter;

//    private DBOpenHelper dbHelper;
//    private SQLiteDatabase db;

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
//        dbHelper = new DBOpenHelper(this);
//
        // List Data
        Cursor cursor = DBInfo.DB_ADAPTER.getAllRow(DBInfo.TABLE_MESSAGE);
//        db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from " + DBInfo.TABLE_MESSAGE, null);

        // data < --- > layout ==> List item
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                new String[]{DBInfo.KEY_TITLE, DBInfo.KEY_CONTENT},
                new int[] {android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        // ListView <== List 설정
        viewLST.setAdapter(adapter);

        viewLST.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "=> onLongClick() id : " + id + " | position : " + position);

                DBInfo.DB_ADAPTER.deleteRow(DBInfo.TABLE_MESSAGE, id);

                adapter.changeCursor(DBInfo.DB_ADAPTER.getAllRow(DBInfo.TABLE_MESSAGE));
                return true;
            }
        });
    }
}