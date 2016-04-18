package com.example.user.rollcallingwithfragment;

/**
 * Created by user on 2015/3/24.
 */
public class Student {
    public int picture;
    public String name;
    public String department;
    public String note;

    public Student() {
        this.picture = 0;
        this.name = "";
        this.department = "";
        this.note = "";
    }

    public Student(int picture, String name, String department, String note) {
        this.picture = picture;
        this.name = name;
        this.department = department;
        this.note = note;
    }
}
