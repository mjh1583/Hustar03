package com.example.examdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// SQLite Database 관련된 모든 메서드
public class DBAdapter {
    // Member Variable -----------------------------------------------------------------------------
    private static final String TAG = "EXAM_DB";
    private DBOpenHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    // Member Method - Constructor -----------------------------------------------------------------
    public DBAdapter(Context context) {
        this.context = context;
        this.dbHelper = new DBOpenHelper(context);
        Log.i(TAG, "=> DBAdapter : constructor()");
    }

    // Member Method - Override --------------------------------------------------------------------
    // Member Method - Custom ----------------------------------------------------------------------
    // DB Open & Close
    public void openDB(boolean isWrite) {
        if(isWrite)
            this.db = dbHelper.getWritableDatabase();
        else
            this.db = dbHelper.getReadableDatabase();
        Log.i(TAG, "=> DBAdapter : openDB()");
    }

    public void closeDB() {
        if(db.isOpen())
            dbHelper.close();
        Log.i(TAG, "=> DBAdapter : closeDB()");
    }

    // DB Insert/Update/Delete ---------------------------------------------------------------------
    public long insertRow(String tableName, ContentValues newValue) {
        openDB(true);

        long rowId = db.insert(tableName, null, newValue);

        closeDB();
        Log.i(TAG, "=> DBAdapter : insertRow() rowId : " + rowId);
        return rowId;
    }

    public boolean deleteRow(String tableName, long rowId) {
        openDB(true);

        int delNums = db.delete(tableName, DBInfo.KEY_ID + "=" + rowId, null);

        Log.i(TAG, " => DBAdapter : deleteRow() rowId : " + rowId);

        closeDB();

        return (delNums > 0) ? true : false;
    }

    // DB Query ------------------------------------------------------------------------------------
    public Cursor getAllRow(String tableName) {
        openDB(false);

        Cursor cursor = db.rawQuery("select * from " + tableName, null);

        showCursor(cursor);  // Data 확인용
        cursor.moveToFirst();  // Data 전달용
        //closeDB();
        Log.i(TAG, "=> DBAdapter : getAllRow() count : " + cursor.getCount());

        return cursor;
    }

    public Cursor getRow(String tableName) {
        openDB(false);

        Cursor cursor = db.rawQuery("select " + DBInfo.KEY_ID + " from " + tableName, null);

        //showCursor(cursor);  // Data 확인용
        cursor.moveToFirst();  // Data 전달용
        //closeDB();
        Log.i(TAG, "=> DBAdapter : getRow() count : " + cursor.getCount());

        return cursor;
    }

    // Debug Method --------------------------------------------------------------------------------
    private void showCursor(Cursor cursor) {
        if(cursor != null) {
            String temp = "";
            while (cursor.moveToNext()) {
                temp = "[ " + cursor.getInt(cursor.getColumnIndex(DBInfo.KEY_ID)) + " ] ";
                temp += cursor.getString(cursor.getColumnIndex(DBInfo.KEY_TITLE)) + ", ";
                temp += cursor.getString(cursor.getColumnIndex(DBInfo.KEY_CONTENT)) + "\n";
                Log.i(TAG, " => DBAdapter : showCursor() ===> " + temp);
            }
        }
    }

    public int getRowCount(Cursor cursor) {
        if(cursor != null) {
            Log.i(TAG, " => DBAdapter : getRowCount()");
            return cursor.getCount();
        }
        else
            return -1;
    }
}
