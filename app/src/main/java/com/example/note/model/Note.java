package com.example.note.model;

import android.content.ContentValues;
import com.example.note.database.NoteTable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Comparable<Note>{
    private int id;
    private DateFormat dateFormat;
    private String text;
    private String dateTimeString;

    public Note(int pId, String pText){
       id = pId;
       text = pText;
       updateDateAndTime();
    }

    public Note(int id, String text, String date) {
        this.id = id;
        this.text = text;
        this.dateTimeString = date;
    }

    private void updateDateAndTime(){
        Date dateAndTime = new Date();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateTimeString = dateFormat.format(dateAndTime);
    }

    public int getId() {
        return id;
    }

    public String getDateTimeString(){
        return dateTimeString;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        updateDateAndTime();
        this.text = text;
    }

    @Override
    public String toString() {
        String returnString = dateTimeString + ": ";

        if(text.length() <= 12) returnString+=text;
        else returnString += text.substring(0, 8) + "...";

        return returnString;
    }
    @Override
    public int compareTo(Note otherNote){
        return this.dateTimeString.compareTo(otherNote.dateTimeString);
    }
    // Helper method for SQL
    public ContentValues toValues(){
        ContentValues values = new ContentValues();

        values.put(NoteTable.COLUMN_ID, id);
        values.put(NoteTable.COLUMN_TEXT, text);
        values.put(NoteTable.COLUMN_DATE, dateTimeString);

        return values;
    }
}
