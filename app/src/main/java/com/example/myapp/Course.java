package com.example.myapp;

public class Course {
    private String name;
    private String teacherid;
    private String teachername;
    private String date;
    private String id;
    private String olddate;

    public void setOlddate(String olddate) {
        this.olddate = olddate;
    }

    public String getOlddate() {
        return olddate;
    }

    public Course(String id){
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getDate() {
        return date;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public String getId() {
        return id;
    }

    public String getTeachername() {
        return teachername;
    }

    public String getName(){
        return name;
    }
}
