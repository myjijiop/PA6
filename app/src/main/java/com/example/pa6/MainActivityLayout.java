package com.example.pa6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivityLayout extends GridLayout {
        public MainActivityLayout(final Context context) {
            super(context);

            setColumnCount(1);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = LayoutParams.MATCH_PARENT;
            layoutParams.height = LayoutParams.WRAP_CONTENT;

            Button newNoteButton = new Button(context); // this button needs to send us to a new activity
            newNoteButton.setLayoutParams(layoutParams);   // v v v v v v v v v v v v v v v v v v v v
            newNoteButton.setText("Add new note");

            // Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            // Intent intent = new Intent(MainActivity.class, NoteActivity.class);
            // Intent intent = new Intent(MainActivityLayout.this, NoteActivity.class);
            // but none of these work

            addView(newNoteButton);


        }


}
