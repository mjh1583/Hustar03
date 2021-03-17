package com.example.examdb;

// DESC : Database 관련 상수 저장 -------------------------------------------------------------------
public class DBInfo {

    // DB 관련 상수 ---------------------------------------------------------------------------------
    public static final String DB_NAME = "Message.db";
    public static final int DB_VERSION = 1;

    // Table 관련 상수 ------------------------------------------------------------------------------
    public static final String TABLE_MESSAGE = "message_tbl";
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";

    public static final String TABLE_USER = "user_tbl";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
}
