package com.example.pa6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityLayout mainActivityLayout = new MainActivityLayout(this);
        setContentView(mainActivityLayout);

        // Button newNoteButton = (Button) findViewById(R.id.newNoteButton);
        // we also can't find the button in this scope :(
    }
}
