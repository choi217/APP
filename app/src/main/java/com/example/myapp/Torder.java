package com.example.myapp;

public class Torder {
    private String num;
    private String course;
    private String place;
    private String people;

    public Torder(String num,String course,String place, String people){
        this.num = num;
        this.course = course;
        this.place = place;
        this.people = people;
    }

    public String getNum(){
        return num;
    }
    public String getCourse(){
        return course;
    }
    public String getPlace() {return place;}
    public String getPeople() {return people;}
}
