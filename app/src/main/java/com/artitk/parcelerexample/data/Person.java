package com.artitk.parcelerexample.data;

import org.parceler.Parcel;

@Parcel
public class Person {

    public enum Gender {
        MALE,
        FEMALE
    }

    String fullname;
    Gender gender;
    int age;

    public Person() { /* Required empty bean constructor */ }

    public Person(String fullname, Gender gender, int age) {
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
