package com.example.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView noteListView;

    Controller controller;
    ArrayAdapter<Note> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notelist);
        controller = Controller.getInstance();
        noteListView = (ListView) findViewById(R.id.note_listview);

        arrayAdapter= new ArrayAdapter<Note>(this, R.layout.notelist, R.id.note_textView, controller.getNoteRepoList());
        noteListView.setAdapter(arrayAdapter);

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                controller.CurrentNote = (Note) arrayAdapter.getItem(position);
                viewNote(view);

            }

        });

    }
    @Override
    protected void onRestart() {


        super.onRestart();

        arrayAdapter.notifyDataSetChanged();
    }

    public void viewNote(View v){
        Intent intent = new Intent(v.getContext(), NoteActivity.class);


        startActivity(intent);
    }




}
