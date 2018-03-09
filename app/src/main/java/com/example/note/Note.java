package com.example.note;
import android.content.ContentValues;

import com.example.note.database.NoteTable;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Locale;

/**
 * Created by dsp on 03/03/2018.
 */

public class Note implements Comparable<Note>{



    private int id;
    private DateFormat dateFormat;

    private Date dateAndTime;
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
        this.dateAndTime = convertStringToDate(date);
    }

    private void updateDateAndTime(){
        dateAndTime = new Date();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateTimeString = dateFormat.format(dateAndTime);


    }

    private Date convertStringToDate(String dateString){

        Date date = null;
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);

        try{
            date = formatter.parse(dateString);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }




        return date;


    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        updateDateAndTime();
        this.text = text;

    }

    public Date getDateAndTime() {

        return dateAndTime;
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

        return this.dateAndTime.compareTo(otherNote.getDateAndTime());
    }

    public ContentValues toValues(){
        ContentValues values = new ContentValues();

        values.put(NoteTable.COLUMN_ID, id);
        values.put(NoteTable.COLUMN_TEXT, text);
        values.put(NoteTable.COLUMN_DATE, dateTimeString);

        return values;
    }


}
