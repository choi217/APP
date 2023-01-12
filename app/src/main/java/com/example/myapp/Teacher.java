package com.example.myapp;

public class Teacher {
    private String name;
    private int imageId;

    public Teacher(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
