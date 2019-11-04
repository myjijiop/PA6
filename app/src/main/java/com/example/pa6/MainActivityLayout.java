package com.example.pa6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivityLayout extends GridLayout {
        private Button newNoteButton;
        public MainActivityLayout(final Context context) {
            super(context);

            setBackgroundColor(Color.BLACK);

            setColumnCount(1);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = LayoutParams.MATCH_PARENT;
            layoutParams.height = LayoutParams.WRAP_CONTENT;
            newNoteButton = new Button(context); // this button needs to send us to a new activity
            newNoteButton.setLayoutParams(layoutParams);   // v v v v v v v v v v v v v v v v v v v v
            newNoteButton.setText("Add new note");
            addView(newNoteButton);
        }
        public Button returnButton(){
            return newNoteButton;
        }
//    private void goButtonClicked() {
//        startAcivity(intent);
//    }



}
