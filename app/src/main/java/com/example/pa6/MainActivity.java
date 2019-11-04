package com.example.pa6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent(this,NoteActivity.class);
        MainActivityLayout mainActivityLayout = new MainActivityLayout(this);

        // wow im a genius
        mainActivityLayout.returnButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        // Holy cow im so smart 
        List<Note> NoteList = new ArrayList<>();
        NoteList.add(new Note("HP and Sorcerer's Stone", "JKR","School"));
        NoteList.add(new Note("Aye whats good","nothing much, wbu","Work"));
        NoteList.add(new Note("HP and Chamber of Secrets", "JKR", "Personal"));


        // set up an array adapter to be the middleman between our data source
        // (myBooks) and our adapterview (listView)
        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, NoteList);
        mainActivityLayout.returnListView().setAdapter(arrayAdapter);

        // force an update
        arrayAdapter.notifyDataSetChanged();

        setContentView(mainActivityLayout);

    }
}
