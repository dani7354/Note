package com.example.note;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class NoteArrayAdapter extends ArrayAdapter<Note> {


    public NoteArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
