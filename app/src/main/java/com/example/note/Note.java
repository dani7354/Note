package com.example.note;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;

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


       updateDateAndTime();



    }

    private void updateDateAndTime(){
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
        updateDateAndTime();
    }

    public String getDateTime() {

        return dateTime;
    }

    @Override
    public String toString() {
        String returnString = dateTime + ": ";

        if(text.length() <= 12) returnString+=text;
        else returnString += text.substring(0, 8) + "...";



        return returnString;


    }

}
