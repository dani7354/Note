package com.example.note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView noteListView;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notelist);
        controller = Controller.getInstance();
        noteListView = (ListView) findViewById(R.id.note_listview);

        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<Note>(this, R.layout.notelist, R.id.note_textView,  controller.getNoteRepoList());
        noteListView.setAdapter(arrayAdapter);
    }
}
