package com.example.note;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    Controller controller;
    EditText note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_layout);

        controller = Controller.getInstance();

        showNote();



    }
    @Override
    public void onBackPressed()
    {

        String updatedText = note.getText().toString();
        controller.updateNote(updatedText);
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showNote();
    }

    public void showNote(){
        note = findViewById(R.id.edittext_noteinput);
        note.setText(controller.CurrentNote.getText());

    }
}
