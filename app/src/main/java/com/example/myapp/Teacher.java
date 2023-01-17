package com.example.myapp;

public class Teacher {
    private String name;
    private int imageId;
    private String id;
    private String province;
    private String subject;
    private String degree;//学历
    private String sex;
    private String teachmethod;
    private float score;
    private String otherinfo;
    private int age;
    private String major;
    private String home;
    private String phone;
    private String school;
    private String moneyrequest;


    public Teacher(String name, int imageId,String id){
        this.name = name;
        this.imageId = imageId;
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setMoneyrequest(String moneyrequest) {
        this.moneyrequest = moneyrequest;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setProvince(String province){
        this.province = province;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }

    public void setSex(String sex){
        this.sex = sex;
    }
    public void setTeachmethod(String teachmethod){
        this.teachmethod = teachmethod;
    }
    public void setScore(float score){
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public String getDegree() {
        return degree;
    }

    public String getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public String getSex() {
        return sex;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeachmethod() {
        return teachmethod;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getHome() {
        return home;
    }

    public String getMajor() {
        return major;
    }

    public String getMoneyrequest() {
        return moneyrequest;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public String getPhone() {
        return phone;
    }

    public String getSchool() {
        return school;
    }


    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
