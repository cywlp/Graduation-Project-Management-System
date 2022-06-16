package com.example.bean;

public class AdminTeacher {
    Integer id;
    String number;
    String pwd;
    String name;
    String telephone;
    String nation;
    String sex;
    String email;
    String origin;
    String academy;

    public AdminTeacher() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "AdminTeacher{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nation='" + nation + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", origin='" + origin + '\'' +
                ", academy='" + academy + '\'' +
                '}';
    }
}
