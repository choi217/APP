package com.example.myapp.entity;
public class User {
    public String username;//用户名
    public int id;//id
    public String password;
    public int teacherid;
    public float money;
    public String email;
    public int studentid;

    public boolean setuserbyid(int id){
        return false;
    }

    public boolean setuserbyusername(String username){
        return false;
    }

}