package com.example.note;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dsp on 03/03/2018.
 */

public class Note {



    private int id;



    private String text;

    private String dateTime;

    public Note(int pId, String pText){
       id = pId;
       text = pText;

       //set dateTime
        Date dateAndTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateTime = dateFormat.format(dateAndTime);
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getDateTime() {

        return dateTime;
    }

    @Override
    public String toString() {
        return id +": " +  text + " Date: " + dateTime;
    }
}
