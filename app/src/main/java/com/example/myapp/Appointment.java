package com.example.myapp;

public class Appointment {
    private String course;
    private String state;

    public Appointment(String course, String state){
        this.course = course;
        this.state = state;
    }

    public String getCourse(){
        return course;
    }
    public String getState(){
        return state;
    }
}
