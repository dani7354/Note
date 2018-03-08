package com.example.note.database;

/**
 * Created by dsp on 08/03/2018.
 */

public class NoteTable {


    public static final String TABLE_NOTE = "note";
    public static final String COLUMN_ID = "noteId";
    public static final String COLUMN_TEXT = "noteText";
    public static  final String COLUMN_DATE = "noteEditDate";

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE_NOTE + "("+
            COLUMN_ID + " INT PRIMARY KEY," +
            COLUMN_TEXT + " TEXT," +
            COLUMN_DATE + " DATE" + ");";

    public static final String SQL_DELETE = "DROP TABLE " + TABLE_NOTE;



    //Database design goes here
}
