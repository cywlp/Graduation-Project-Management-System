package com.example.bean;

public class AdminStudent {
    Integer id;
    String number;
    String pwd;
    String name;
    String major;
    String telephone;
    String grade;
    String a_class;
    String nation;
    String sex;
    String email;
    String origin;
    String academy;
    Integer status;

    public AdminStudent() {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getA_class() {
        return a_class;
    }

    public void setA_class(String a_class) {
        this.a_class = a_class;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminStudent{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", telephone='" + telephone + '\'' +
                ", grade='" + grade + '\'' +
                ", a_class='" + a_class + '\'' +
                ", nation='" + nation + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", origin='" + origin + '\'' +
                ", academy='" + academy + '\'' +
                ", status=" + status +
                '}';
    }
}
