package com.example.pa6;

import androidx.annotation.NonNull;

public class Note {
    private String title;
    private String content;
    private int type;


    // DVC
    Note(){
        this.title = "";
        this.content= "";
        this.type = -1;
    }

    //EVC
    Note(String title, String content, int type){
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
