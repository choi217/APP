package com.example.myapp;

public class Messager {
    private String userid;
    private String fid;
    private String toid;
    private String date;
    private String text;
    private String ops;
    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public String getOname() {
        return oname;
    }

    public String getOps() {
        return ops;
    }
    public void setoo(){
        if(userid.equals(toid)){
            this.ops = fid;
        }else{
            this.ops = toid;
        }
    }
    public Messager(String userid){
        this.userid=userid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getDate() {
        return date;
    }

    public String getFid() {
        return fid;
    }

    public String getText() {
        return text;
    }

    public String getToid() {
        return toid;
    }
}
