package cn.edu.hqu.cst.android.chapter34.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String password;
    private String gender;
    private String city;

    public Person(String name, String password, String gender, String city) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
