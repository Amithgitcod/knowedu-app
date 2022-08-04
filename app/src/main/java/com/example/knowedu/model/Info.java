package com.example.knowedu.model;

public class Info {
    private int id;
    private String name;
    private String email;
    private String marks;

    public Info(String name, String email, String marks){
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    public Info() {

    }

    public Info(int parseInt, String string, String string1, String string2) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public int getId(int anInt) {
        return id;
    }
}
