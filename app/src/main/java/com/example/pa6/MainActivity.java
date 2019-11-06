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

        // force an update
        setContentView(mainActivityLayout);
    }

    private class NoteButtonClicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            startActivity(intent);
            int noteActivityRequest = 0;
            intent.putExtra("type", "regular");
            startActivityForResult(intent, noteActivityRequest);

        }
    }

    private class listViewItemListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int editNoteActivityRequest = 1;
            String selection = parent.getItemAtPosition(position).toString();
            //Toast.makeText(getApplicationContext(),selection,Toast.LENGTH_SHORT).show();
            intent.putExtra("type", "edit");
            String content;
            String title;
            int spinner;
            Note temp = (Note) parent.getItemAtPosition(position);
            title = temp.getTitle();
            content = temp.getContent();
            spinner = temp.getType();
            intent.putExtra("spinner", spinner);
            intent.putExtra("content", content);
            intent.putExtra("title", title);


            startActivityForResult(intent, editNoteActivityRequest);
            // takes us to expanded note entry
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
        if (requestCode == 0) {
            String temp = data.getStringExtra("title");
            NoteList.add(new Note(temp, "", -1));
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
