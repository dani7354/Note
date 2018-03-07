package com.example.note;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by dsp on 07/03/2018.
 */

public class NoteArrayAdapter extends ArrayAdapter<Note> {
    public NoteArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
