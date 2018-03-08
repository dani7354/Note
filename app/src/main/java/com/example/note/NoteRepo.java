package com.example.note;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Note> getNoteList(){
        return noteList;
    }


    public void addNote(Note note){
        noteList.add(note);
    }

    public void deleteNote(Note note){
        noteList.remove(note);
    }

    public void sortList(){
        Collections.sort(noteList);
        Collections.reverse(noteList);


    }



}
