package com.example.myapp;

public class Course {
    private String name;
    private String state;

    public Course(String name, String state){
        this.name = name;
        this.state = state;
    }

    public String getName(){
        return name;
    }
    public String getstate(){
        return state;
    }
}
