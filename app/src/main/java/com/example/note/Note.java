package com.example.note;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;

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

    private void updateDateAndTime(){
        dateAndTime = new Date();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateTimeString = dateFormat.format(dateAndTime);

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


}
