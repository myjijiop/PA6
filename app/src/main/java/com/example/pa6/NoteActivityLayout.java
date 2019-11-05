package com.example.pa6;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
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
    private Button doneButton;

    public NoteActivityLayout(final Context context) {
        super(context);
        setColumnCount(2);


        titleET = new EditText(context);
        contentET = new EditText(context);
        spinner = new Spinner(context);
        doneButton = new Button(context);

        titleET.setHint("TITLE HOLDEr");
        contentET.setHint("CONTENT HOLDER");

        GridLayout.Spec rowSpec = GridLayout.spec(0,1,1);
        GridLayout.Spec colSpec = GridLayout.spec(0,1,2);
        layoutParams = new LayoutParams(rowSpec,colSpec);
        titleET.setLayoutParams(layoutParams);
        rowSpec = GridLayout.spec(0,1,1);
        colSpec = GridLayout.spec(1,1,1);
        layoutParams = new LayoutParams(rowSpec,colSpec);
        spinner.setLayoutParams(layoutParams);
        rowSpec = GridLayout.spec(1,1,13);
        colSpec = GridLayout.spec(0,2,2);
        layoutParams = new LayoutParams(rowSpec,colSpec);
        contentET.setLayoutParams(layoutParams);
        rowSpec = GridLayout.spec(2,1,1);
        colSpec = GridLayout.spec(0,2,1);
        layoutParams = new LayoutParams(rowSpec,colSpec);
        doneButton.setLayoutParams(layoutParams);

        contentET.setGravity(Gravity.TOP|Gravity.LEFT);

        addView(titleET);
        addView(spinner);
        addView(contentET);
        addView(doneButton);
    }
    public Button getDoneButton(){
        return doneButton;
    }
    public EditText returnTitleET(){
        return titleET;
    }
    public EditText returnContentET(){
        return contentET;
    }
    public Spinner returnSpinner(){
        return spinner;
    }

}
