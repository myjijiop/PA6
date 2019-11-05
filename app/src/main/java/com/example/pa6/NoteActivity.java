package com.example.pa6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NoteActivity extends AppCompatActivity {
    private Button doneButton;
    private EditText titleET;
    private EditText contentET;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        NoteActivityLayout noteActivityLayout = new NoteActivityLayout(this);

        doneButton = noteActivityLayout.getDoneButton();
        titleET = noteActivityLayout.returnTitleET();
        contentET = noteActivityLayout.returnContentET();
        spinner = noteActivityLayout.returnSpinner();

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent output = new Intent();
                output.putExtra("title", titleET.getText().toString());
                setResult(RESULT_OK, output);
                finish();
            }
        });

        setContentView(noteActivityLayout);
    }
}
