package com.example.myapp;

public class Video {
    private String name;
    private String describe;
    private String grade;
    private String url;
    private String imageurl;
    private String subject;
    private String price;
    private String teacherid;
    private String hot;
    private String score;
    private String videoid;
    private String courseid;
    public Video(String name){
        this.name =name;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getHot() {
        return hot;
    }

    public String getScore() {
        return score;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescribe() {
        return describe;
    }

    public String getGrade() {
        return grade;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public String getUrl() {
        return url;
    }
}