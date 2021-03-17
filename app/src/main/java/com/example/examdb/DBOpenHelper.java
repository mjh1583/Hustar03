package com.example.examdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    // Member Variable -----------------------------------------------------------------------------
    private static final String TAG = "EXAM_DB";

    private static final String CREATE_TABLE_MESSAGE = "create table if not exists " +
            DBInfo.TABLE_MESSAGE +
            "(" + DBInfo.KEY_ID + " integer primary key autoincrement, " +
            DBInfo.KEY_TITLE + " text not null, " +
            DBInfo.KEY_CONTENT + " text not null );";

    private static final String DROP_TABLE_MESSAGE = "drop table if exists " +
            DBInfo.TABLE_MESSAGE + ";";

    private Context context;

    // Member Method - Constructor------------------------------------------------------------------
    // 지정된 이름의 Database 생성
    public DBOpenHelper(@Nullable Context context) {
        super(context, DBInfo.DB_NAME, null, DBInfo.DB_VERSION);
        this.context = context;
        Log.i(TAG, " => DBOpenHelper : DBOpenHelper() 1");
    }

    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        Log.i(TAG, " => DBOpenHelper : DBOpenHelper() 2");
    }

    // Member Method - Override---------------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, " => DBOpenHelper : onCreate()");
        // Table 생성
        //db.execSQL(DROP_TABLE_MESSAGE);
        db.execSQL(CREATE_TABLE_MESSAGE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // DB 업그레이드 시에 사용
        // 기존 Table 삭제
        db.execSQL(DROP_TABLE_MESSAGE);
        // Table 새로 생성
        onCreate(db);

        Log.i(TAG, " => DBOpenHelper : onUpgrade()");
    }
}
