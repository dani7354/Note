package com.example.note;

import java.util.ArrayList;

/**
 * Created by dsp on 03/03/2018.
 */

public class Controller {



    private static Controller Instance = new Controller();

    private NoteRepo noteRepository;


    public static final Controller getInstance() {
        return Instance;
    }

    public Note CurrentNote;

    private Controller(){
        noteRepository = new NoteRepo();

        //For test purposes
        CreateNote("Note 1");
        CreateNote("Note 2");
        CreateNote("Note 3");

    }

    public void CreateNote(String noteString){


        CurrentNote = new Note(noteRepository.getNoteListCount(), noteString);

        noteRepository.addNote(CurrentNote);
    }

    public void createNote(){
        CurrentNote = new Note(noteRepository.getNoteListCount(), "");
        noteRepository.addNote(CurrentNote);

    }

    public void removeNote(){
        noteRepository.deleteNote(CurrentNote);
        CurrentNote = null;
    }

    public void updateNote(String updatedText){
        CurrentNote.setText(updatedText);
    }

    public int GetRepoSize(){
        return noteRepository.getNoteListCount();
    }
    public void SortNotes(){
        noteRepository.sortList();
    }

    public ArrayList<Note> getNoteRepoList(){
        return noteRepository.getNoteList();
    }
    

}
