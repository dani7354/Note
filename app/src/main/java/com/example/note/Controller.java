package com.example.note;

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
    }

    public void CreateNote(String noteString){


        CurrentNote = new Note(noteRepository.getNoteListCount()-1, noteString);

        noteRepository.addNote(CurrentNote);
    }

    public int GetRepoSize(){
        return noteRepository.getNoteListCount();
    }







}
