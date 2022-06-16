package com.example.bean;

import java.sql.Date;

/*
    学生实体类
 */
public class Student {
    Integer s_id;
    String s_number;
    String s_name;
    String s_pwd;
    String s_photo;
    String s_major;
    String s_telephone;
    String s_grade;
    String s_class;
    String s_sex;
    String s_email;
    String s_origin;
    String s_academy;
    String s_nation;
    Integer s_status;

    public Student() {
    }

    public Student(Integer s_id, String s_number, String s_name, String s_pwd, String s_photo, String s_major, String s_telephone, String s_grade, String s_class, String s_sex, String s_email, String s_origin, String s_academy, String s_nation, Integer s_status) {
        this.s_id = s_id;
        this.s_number = s_number;
        this.s_name = s_name;
        this.s_pwd = s_pwd;
        this.s_photo = s_photo;
        this.s_major = s_major;
        this.s_telephone = s_telephone;
        this.s_grade = s_grade;
        this.s_class = s_class;
        this.s_sex = s_sex;
        this.s_email = s_email;
        this.s_origin = s_origin;
        this.s_academy = s_academy;
        this.s_nation = s_nation;
        this.s_status = s_status;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_pwd() {
        return s_pwd;
    }

    public void setS_pwd(String s_pwd) {
        this.s_pwd = s_pwd;
    }

    public String getS_photo() {
        return s_photo;
    }

    public void setS_photo(String s_photo) {
        this.s_photo = s_photo;
    }

    public String getS_major() {
        return s_major;
    }

    public void setS_major(String s_major) {
        this.s_major = s_major;
    }

    public String getS_telephone() {
        return s_telephone;
    }

    public void setS_telephone(String s_telephone) {
        this.s_telephone = s_telephone;
    }

    public String getS_grade() {
        return s_grade;
    }

    public void setS_grade(String s_grade) {
        this.s_grade = s_grade;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_origin() {
        return s_origin;
    }

    public void setS_origin(String s_origin) {
        this.s_origin = s_origin;
    }

    public String getS_academy() {
        return s_academy;
    }

    public void setS_academy(String s_academy) {
        this.s_academy = s_academy;
    }

    public String getS_nation() {
        return s_nation;
    }

    public void setS_nation(String s_nation) {
        this.s_nation = s_nation;
    }

    public Integer getS_status() {
        return s_status;
    }

    public void setS_status(Integer s_status) {
        this.s_status = s_status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_number='" + s_number + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_pwd='" + s_pwd + '\'' +
                ", s_photo='" + s_photo + '\'' +
                ", s_major='" + s_major + '\'' +
                ", s_telephone='" + s_telephone + '\'' +
                ", s_grade='" + s_grade + '\'' +
                ", s_class='" + s_class + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_email='" + s_email + '\'' +
                ", s_origin='" + s_origin + '\'' +
                ", s_academy='" + s_academy + '\'' +
                ", s_nation='" + s_nation + '\'' +
                ", s_status=" + s_status +
                '}';
    }
}
