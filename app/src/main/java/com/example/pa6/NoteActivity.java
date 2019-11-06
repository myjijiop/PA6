package com.example.pa6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity {
    private Button doneButton;
    private EditText titleET;
    private EditText contentET;
    private Spinner spinner;
    private Intent intent;
    private int notePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        NoteActivityLayout noteActivityLayout = new NoteActivityLayout(this);

        doneButton = noteActivityLayout.getDoneButton();
        titleET = noteActivityLayout.returnTitleET();
        contentET = noteActivityLayout.returnContentET();
        spinner = noteActivityLayout.returnSpinner();

        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Personal");
        spinnerArray.add("Work");
        spinnerArray.add("School");
        spinnerArray.add("Other");

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        Bundle extras = getIntent().getExtras();
        String extraStr = extras.getString("type");

        // Checks to see what kind of Activity start it is
        if(extraStr.equals("edit")){
            // comes in here if its a edit existing item
            String existingTitle = extras.getString("title");
            String existingContent= extras.getString("content");
            int existingSpinner = extras.getInt("spinner");

            notePosition = extras.getInt("position");;
            titleET.setText(existingTitle);
            contentET.setText(existingContent);
            spinner.setSelection(existingSpinner);
        } else {
            Toast.makeText(getApplicationContext(),"Regular",Toast.LENGTH_SHORT).show();
        }


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent output = new Intent();
                output.putExtra("title", titleET.getText().toString());
                output.putExtra("content", contentET.getText().toString());
                output.putExtra("spinnerLocation", spinner.getSelectedItemPosition());
                output.putExtra("notePosition",notePosition);
                setResult(RESULT_OK, output);
                finish();
            }
        });

        setContentView(noteActivityLayout);
    }
}
