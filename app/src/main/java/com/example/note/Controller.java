package com.example.note;

import android.content.Context;

import com.example.note.model.Note;
import com.example.note.model.NoteRepo;

import java.util.ArrayList;

public class Controller {
    private static final Controller Instance = new Controller();
    public static final Controller getInstance() {
        return Instance;
    }

    private NoteRepo noteRepository;

    private Context context;

    public Note CurrentNote;
    private void createRepo(){

        noteRepository = new NoteRepo(context);
    }

    private Controller(){

    }
    public void setContext(Context context) {
        this.context = context;
        createRepo();
    }

    public void CreateNote(String noteString){

        CurrentNote = new Note(noteRepository.getNoteListCount(), noteString);
        noteRepository.addNote(CurrentNote);
    }

    public void createNote(){
        CurrentNote = new Note(noteRepository.getNoteListCount()+1, "");
        noteRepository.addNote(CurrentNote);

    }

    public void removeNote(){
        noteRepository.deleteNote(CurrentNote);
        CurrentNote = null;
    }

    public void updateNote(String updatedText){
        CurrentNote.setText(updatedText);
        noteRepository.updateNote(CurrentNote);
    }

    public void SortNotes(){
        noteRepository.sortList();
    }

    public ArrayList<Note> getNoteRepoList(){
        return noteRepository.getNoteList();
    }
}
