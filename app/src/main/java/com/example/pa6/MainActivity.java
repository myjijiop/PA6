package com.example.pa6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private Button noteButton;
    private ListView listView;
    private List<Note> NoteList;
    private ArrayAdapter<Note> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent(this, NoteActivity.class);
        MainActivityLayout mainActivityLayout = new MainActivityLayout(this);

        // wow im a genius
        noteButton = mainActivityLayout.returnButton();
        noteButton.setOnClickListener(new NoteButtonClicker());

        // Holy cow im so smart
        NoteList = new ArrayList<>();
        NoteList.add(new Note("HP and Sorcerer's Stone", "JKR", 0));
        NoteList.add(new Note("Aye whats good", "nothing much, wbu", 1));
        NoteList.add(new Note("HP and Chamber of Secrets", "JKR", 2));


        // set up an array adapter to be the middleman between our data source
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteList);
        listView = mainActivityLayout.returnListView();
        listView.setOnItemClickListener(new listViewItemListener());
        listView.setOnItemLongClickListener(new listViewLongClickListener());
        listView.setAdapter(arrayAdapter);

        setContentView(mainActivityLayout);
    }

    private class NoteButtonClicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int noteActivityRequest = 0;
            intent.putExtra("type", "regular");
            startActivityForResult(intent, noteActivityRequest);
        }
    }

    private class listViewItemListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int editNoteActivityRequest = 1;
            String content;
            String title;
            int spinner;
            int notePosition;

            Note noteSelectedItem = (Note) parent.getItemAtPosition(position);
            title = noteSelectedItem.getTitle();
            content = noteSelectedItem.getContent();
            spinner = noteSelectedItem.getType();
            notePosition = NoteList.indexOf(noteSelectedItem);

            intent.putExtra("spinner", spinner);
            intent.putExtra("content", content);
            intent.putExtra("title", title);
            intent.putExtra("position",notePosition);
            intent.putExtra("type", "edit");

            startActivityForResult(intent, editNoteActivityRequest);
        }
    }

    private class listViewLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getApplicationContext(),"Loooooong Click",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String noteItemTitle;
        String noteItemContent;
        int noteItemSpinner;

        noteItemTitle = data.getStringExtra("title");
        noteItemContent = data.getStringExtra("content");
        noteItemSpinner = data.getIntExtra("spinnerLocation",-1);
        if (requestCode == 0) {
            // Comes in here if requestcode was for creating new item
            NoteList.add(new Note(noteItemTitle, noteItemContent, noteItemSpinner));
        } if(requestCode == 1){
            // Comes in here if requestcode was for editing existing Note Item
            int indexPosition = data.getIntExtra("notePosition",-1);
            NoteList.get(indexPosition).setTitle(noteItemTitle);
            NoteList.get(indexPosition).setContent(noteItemContent);
            NoteList.get(indexPosition).setType(noteItemSpinner);
        }
        arrayAdapter.notifyDataSetChanged();
    }
}
