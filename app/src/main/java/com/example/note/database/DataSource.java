package com.example.note.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.note.model.Note;

import java.util.ArrayList;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context){
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDatabase.close();
    }

    public void createNote(Note note){
        ContentValues values = note.toValues();
        open();
        mDatabase.insert(NoteTable.TABLE_NOTE, null, values);
        close();

    }

    public void deleteNote(Note note){
        open();
        mDatabase.delete(NoteTable.TABLE_NOTE, NoteTable.COLUMN_ID + "=" +note.getId(), null );
        close();
    }

    public void updateNote(Note note){
        ContentValues values = note.toValues();
        open();
        mDatabase.update(NoteTable.TABLE_NOTE, values, NoteTable.COLUMN_ID + "=" + note.getId(), null);
        close();
    }

    public ArrayList<Note> loadFromDB(){
        ArrayList<Note> loadedItems = new ArrayList<>();
        Cursor cursor = mDatabase.query(NoteTable.TABLE_NOTE, NoteTable.ALL_COLUMNS, null, null, null, null, null);

        while(cursor.moveToNext()){

            int id = cursor.getInt(cursor.getColumnIndex(NoteTable.COLUMN_ID));
            String text = cursor.getString(cursor.getColumnIndex(NoteTable.COLUMN_TEXT));
            String date = cursor.getString(cursor.getColumnIndex(NoteTable.COLUMN_DATE));
            Note noteFromDb = new Note(id, text, date);

            loadedItems.add(noteFromDb);
        }
        return loadedItems;
    }

    public long getDbNotesCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, NoteTable.TABLE_NOTE);
    }


}
