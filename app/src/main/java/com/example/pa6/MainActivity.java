package com.example.pa6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private Button noteButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent(this,NoteActivity.class);
        MainActivityLayout mainActivityLayout = new MainActivityLayout(this);

        // wow im a genius

        noteButton = mainActivityLayout.returnButton();
        noteButton.setOnClickListener(new NoteButtonClicker());

        // Holy cow im so smart
        List<Note> NoteList = new ArrayList<>();
        NoteList.add(new Note("HP and Sorcerer's Stone", "JKR","School"));
        NoteList.add(new Note("Aye whats good","nothing much, wbu","Work"));
        NoteList.add(new Note("HP and Chamber of Secrets", "JKR", "Personal"));


        // set up an array adapter to be the middleman between our data source
        // (myBooks) and our adapterview (listView)
        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, NoteList);
        listView = mainActivityLayout.returnListView();
        listView.setOnItemClickListener(new listViewItemListener());
        listView.setOnItemLongClickListener(new listViewLongClickListener());
        listView.setAdapter(arrayAdapter);

        // force an update
        arrayAdapter.notifyDataSetChanged();
        setContentView(mainActivityLayout);
    }
    private class NoteButtonClicker implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            startActivity(intent);
        }
    }
    private class listViewItemListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(),"OnItemClickListener",Toast.LENGTH_SHORT).show();
            // takes us to expanded note entry
        }
    }
    private class listViewLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getApplicationContext(),"Loooooong Click",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
