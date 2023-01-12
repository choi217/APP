package com.example.myapp;

public class Order {
    private String order;
    private String teacher;
    private String money;

    public Order(String order, String teacher,String money){
        this.order = order;
        this.teacher = teacher;
        this.money = money;
    }

    public String getOrder(){
        return order;
    }
    public String getTeacher(){
        return teacher;
    }
    public String getMoney() {return money;}
}
