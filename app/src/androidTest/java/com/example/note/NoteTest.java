package com.example.note;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by dsp on 03/03/2018.
 */
public class NoteTest {
    NoteRepo nr1;
    Controller controller;
    Note n1;
    Note n2;



    @Test
    public void CanCreateNote(){

        Date dateAndTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateTime = dateFormat.format(dateAndTime);

        n1 = new Note(1, "CC");
        n2 = new Note(2, "Ce matin, j'ai écrit une note");

        Assert.assertEquals("1: CC Date: " + dateTime, n1.toString());
        Assert.assertEquals("2: Ce matin, j'ai écrit une note Date: "+ dateTime, n2.toString());

    }
    @Test
    public void CanAddToRepo(){
        controller = Controller.getInstance();

        controller.CreateNote("Hey hey hey");
        controller.CreateNote("Hey hey ");
        controller.CreateNote("Hey");

        Assert.assertEquals(3, controller.GetRepoSize());

    }





}