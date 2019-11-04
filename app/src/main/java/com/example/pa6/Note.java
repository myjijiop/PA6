package com.example.pa6;

public class Note {
    private String title;
    private String content;
    private String type;


    // DVC
    Note(){
        this.title = "";
        this.content= "";
        this.type = "";
    }

    //EVC
    Note(String title, String content, String type){
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
