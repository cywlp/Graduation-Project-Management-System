package com.example.bean;

public class Teacher {
    Integer t_id;
    String t_name;
    String t_pwd;
    String t_photo;
    String t_major;
    String t_telephone;
    String t_grade;
    String t_sex;
    String t_email;
    String t_origin;
    String t_academy;

    String t_nation;
    String t_number;

    public Teacher() {
    }

    public Teacher(Integer t_id, String t_name, String t_pwd, String t_photo, String t_major, String t_telephone, String t_grade, String t_sex, String t_email, String t_origin, String t_academy, String t_nation, String t_number) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_pwd = t_pwd;
        this.t_photo = t_photo;
        this.t_major = t_major;
        this.t_telephone = t_telephone;
        this.t_grade = t_grade;
        this.t_sex = t_sex;
        this.t_email = t_email;
        this.t_origin = t_origin;
        this.t_academy = t_academy;
        this.t_nation = t_nation;
        this.t_number = t_number;
    }

    public Integer getT_id() {
        return t_id;
    }

    public String getT_nation() {
        return t_nation;
    }

    public void setT_nation(String t_nation) {
        this.t_nation = t_nation;
    }

    public String getT_number() {
        return t_number;
    }

    public void setT_number(String t_number) {
        this.t_number = t_number;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_pwd() {
        return t_pwd;
    }

    public void setT_pwd(String t_pwd) {
        this.t_pwd = t_pwd;
    }

    public String getT_photo() {
        return t_photo;
    }

    public void setT_photo(String t_photo) {
        this.t_photo = t_photo;
    }

    public String getT_major() {
        return t_major;
    }

    public void setT_major(String t_major) {
        this.t_major = t_major;
    }

    public String getT_telephone() {
        return t_telephone;
    }

    public void setT_telephone(String t_telephone) {
        this.t_telephone = t_telephone;
    }

    public String getT_grade() {
        return t_grade;
    }

    public void setT_grade(String t_grade) {
        this.t_grade = t_grade;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    public String getT_origin() {
        return t_origin;
    }

    public void setT_origin(String t_origin) {
        this.t_origin = t_origin;
    }

    public String getT_academy() {
        return t_academy;
    }

    public void setT_academy(String t_academy) {
        this.t_academy = t_academy;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_pwd='" + t_pwd + '\'' +
                ", t_photo='" + t_photo + '\'' +
                ", t_major='" + t_major + '\'' +
                ", t_telephone='" + t_telephone + '\'' +
                ", t_grade='" + t_grade + '\'' +
                ", t_sex='" + t_sex + '\'' +
                ", t_email='" + t_email + '\'' +
                ", t_origin='" + t_origin + '\'' +
                ", t_academy='" + t_academy + '\'' +
                '}';
    }
}
