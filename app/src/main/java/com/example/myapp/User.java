package com.example.myapp;

public class User {
    private String username;//用户名
    private int id;//id
    private String password;
    private int teacherid;
    private float money;
    private String email;
    private int studentid;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public float getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }

    public int getStudentid() {
        return studentid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }



}