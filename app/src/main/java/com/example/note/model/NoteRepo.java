package com.example.note.model;

import android.content.Context;
import com.example.note.database.DataSource;
import java.util.ArrayList;
import java.util.Collections;

public class NoteRepo {
    private ArrayList<Note> noteList;
    private DataSource mDataSource;

    private void repoInit(){
        noteList = mDataSource.loadFromDB();
        sortList();
    }

    public NoteRepo(Context context){
        mDataSource = new DataSource(context);
        repoInit();
    }

    public int getNoteListCount(){
        return (int)mDataSource.getDbNotesCount();
    }

    public ArrayList<Note> getNoteList(){
        return noteList;
    }


    public void addNote(Note note){
        noteList.add(note);
        mDataSource.createNote(note);
    }

    public void deleteNote(Note note){
        noteList.remove(note);
        mDataSource.deleteNote(note);
    }
    public void updateNote(Note note){
        mDataSource.updateNote(note);
    }

    public void sortList(){
        Collections.sort(noteList);
        Collections.reverse(noteList);
    }
}
