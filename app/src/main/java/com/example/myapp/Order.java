package com.example.myapp;

public class Order {
    private String id;
    private String grade;
    private String subject;
    private String taketeacherid;
    private String salary;

    public Order(String id){
        this.id= id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setTaketeacherid(String taketeacherid) {
        this.taketeacherid = taketeacherid;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getSalary() {
        return salary;
    }

    public String getTaketeacherid() {
        return taketeacherid;
    }
}
