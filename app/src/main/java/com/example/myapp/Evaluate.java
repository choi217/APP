package com.example.myapp;

public class Evaluate {
    private String evaluate;
    private String id;
    private String content;

    public Evaluate(String evaluate, String id,String content){
        this.evaluate = evaluate;
        this.id = id;
        this.content = content;
    }

    public String getEvaluate(){
        return evaluate;
    }
    public String getId(){
        return id;
    }
    public String getContent() {return content;}
}
