package com.example.myapp;

public class Videoclass {
    private String name;
    private String info;
    private String state;
    private int imageId;

    public Videoclass(String name,String info,String state, int imageId){
        this.name = name;
        this.info = info;
        this.state = state;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }
    public String getInfo() {return info;}
    public String getState() {return state;}
    public int getImageId(){
        return imageId;
    }
}
