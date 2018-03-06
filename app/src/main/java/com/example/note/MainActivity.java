package com.example.note;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


        // Item long click to opn dialog for deletion
      noteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
           @Override
           public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                          int position, long id) {

              controller.CurrentNote = (Note) arrayAdapter.getItem(position);
               showConfirmDeleteDialog();

               return true;
           }
        });

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        arrayAdapter.notifyDataSetChanged();
    }

    //Opens a new activity which shows a note.
    public void viewNote(View v){
        Intent intent = new Intent(v.getContext(), NoteActivity.class);
        startActivity(intent);
    }


    // Dialog window for deleting a note
    public void showConfirmDeleteDialog(){
        AlertDialog.Builder confirmDelete = new AlertDialog.Builder(this);
        confirmDelete.setMessage("Do you really want to delete this note?");
        confirmDelete.setCancelable(true);

        confirmDelete.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        controller.removeNote();
                        arrayAdapter.notifyDataSetChanged();
                      //  dialog.cancel();
                    }
                });

        confirmDelete.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog deletionAlert = confirmDelete.create();
        deletionAlert.show();

    }




}
