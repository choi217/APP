package com.example.myapp;

public class Appointment {
    private String studentid;
    private String teacherid;
    private String teachername;
    private String courseid;
    private String coursename;
    private String date;
    private String done;

    public void setDone(String done) {
        this.done = done;
    }

    public String getDone() {
        return done;
    }

    public Appointment(String studentid){
        this.studentid = studentid;
    }

    public String getTeachername() {
        return teachername;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public String getDate() {
        return date;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }


    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

}
