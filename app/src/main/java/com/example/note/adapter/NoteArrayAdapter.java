package com.example.note.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.note.R;
import com.example.note.model.Note;

import java.util.ArrayList;

public class NoteArrayAdapter extends ArrayAdapter<Note> {


    public NoteArrayAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0,  notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Note note = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_notelist, parent, false);
        }
        TextView noteText = (TextView) convertView.findViewById(R.id.textView_noteText);
        TextView noteDate = (TextView) convertView.findViewById(R.id.textView_noteDate);

        noteText.setText(note.getText());
        noteDate.setText(note.getDateTimeString());

        return convertView;
    }
}
