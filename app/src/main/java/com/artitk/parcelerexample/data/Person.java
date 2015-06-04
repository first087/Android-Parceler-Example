package com.artitk.parcelerexample.data;

import org.parceler.Parcel;

@Parcel
public class Person {

    private String fullname;
    private int gender;
    private int age;

    public Person() { /* Required empty bean constructor */ }

    public Person(String fullname, int gender, int age) {
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public int getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
