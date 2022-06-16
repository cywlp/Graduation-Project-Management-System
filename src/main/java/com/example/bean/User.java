package com.example.bean;
/*
    用户实体类
 */
public class User {
    private Integer id;
    private String number;
    private String pwd;

    public User() {
    }

    public User(Integer id, String number, String pwd) {
        this.id = id;
        this.number = number;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
