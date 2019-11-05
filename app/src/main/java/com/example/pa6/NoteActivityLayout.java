package com.example.pa6;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Spinner;

public class NoteActivityLayout extends GridLayout {
    private GridLayout.LayoutParams layoutParams;
    private EditText titleET;
    private EditText contentET;
    private Spinner spinner;

    public NoteActivityLayout(final Context context) {
        super(context);
        setColumnCount(2);

        layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = LayoutParams.MATCH_PARENT;
        layoutParams.height = LayoutParams.MATCH_PARENT;
        titleET = new EditText(context);
        contentET = new EditText(context);
        spinner = new Spinner(context);

        GridLayout.Spec rowSpec




    }
}
