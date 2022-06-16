package com.example.bean;

public class Teacher_Project {
    Integer t_id;
    Integer p_id;
    String grade;
    String Scale;
    Integer tp_id;

    public Teacher_Project() {
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public Integer getTp_id() {
        return tp_id;
    }

    public void setTp_id(Integer tp_id) {
        this.tp_id = tp_id;
    }

    @Override
    public String toString() {
        return "Teacher_Project{" +
                "t_id=" + t_id +
                ", p_id=" + p_id +
                ", grade='" + grade + '\'' +
                ", Scale='" + Scale + '\'' +
                ", tp_id=" + tp_id +
                '}';
    }
}
