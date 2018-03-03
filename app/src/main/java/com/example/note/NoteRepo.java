package com.example.note;

import java.util.ArrayList;

/**
 * Created by dsp on 03/03/2018.
 */

public class NoteRepo {

    private ArrayList<Note> noteList;

    public NoteRepo(){
        noteList = new ArrayList<>();
    }

    public int getNoteListCount(){
        return noteList.size();
    }


    public void addNote(Note note){
        noteList.add(note);
    }



}
