package com.example.myapp;

public class Video {
    private String name;
    private String state;

    public Video(String name, String state){
        this.name = name;
        this.state = state;
    }

    public String getName(){
        return name;
    }
    public String getState(){
        return state;
    }
}