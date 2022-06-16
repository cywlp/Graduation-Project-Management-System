package com.example.bean;

import java.util.Date;

public class InstructorGrades {
    Integer ig_id;
    Float ig_design;
    Float ig_innovation;
    Float ig_workload;
    Float ig_investigate;
    Float ig_information;
    Float ig_comprehension;
    String ig_comment;
    Date ig_date;

    Float ig_sum;
    String ig_agree;

    String ig_person;

    public InstructorGrades() {
    }

    public Integer getIg_id() {
        return ig_id;
    }

    public void setIg_id(Integer ig_id) {
        this.ig_id = ig_id;
    }

    public Float getIg_design() {
        return ig_design;
    }

    public void setIg_design(Float ig_design) {
        this.ig_design = ig_design;
    }

    public Float getIg_innovation() {
        return ig_innovation;
    }

    public void setIg_innovation(Float ig_innovation) {
        this.ig_innovation = ig_innovation;
    }

    public Float getIg_workload() {
        return ig_workload;
    }

    public void setIg_workload(Float ig_workload) {
        this.ig_workload = ig_workload;
    }

    public Float getIg_investigate() {
        return ig_investigate;
    }

    public void setIg_investigate(Float ig_investigate) {
        this.ig_investigate = ig_investigate;
    }

    public Float getIg_information() {
        return ig_information;
    }

    public void setIg_information(Float ig_information) {
        this.ig_information = ig_information;
    }

    public Float getIg_comprehension() {
        return ig_comprehension;
    }

    public void setIg_comprehension(Float ig_comprehension) {
        this.ig_comprehension = ig_comprehension;
    }

    public String getIg_comment() {
        return ig_comment;
    }

    public void setIg_comment(String ig_comment) {
        this.ig_comment = ig_comment;
    }

    public Date getIg_date() {
        return ig_date;
    }

    public void setIg_date(Date ig_date) {
        this.ig_date = ig_date;
    }

    public Float getIg_sum() {
        return ig_sum;
    }

    public void setIg_sum(Float ig_sum) {
        this.ig_sum = ig_sum;
    }

    public String getIg_agree() {
        return ig_agree;
    }

    public void setIg_agree(String ig_agree) {
        this.ig_agree = ig_agree;
    }

    public String getIg_person() {
        return ig_person;
    }

    public void setIg_person(String ig_person) {
        this.ig_person = ig_person;
    }

    @Override
    public String toString() {
        return "InstructorGrades{" +
                "ig_id=" + ig_id +
                ", ig_design=" + ig_design +
                ", ig_innovation=" + ig_innovation +
                ", ig_workload=" + ig_workload +
                ", ig_investigate=" + ig_investigate +
                ", ig_information=" + ig_information +
                ", ig_comprehension=" + ig_comprehension +
                ", ig_comment='" + ig_comment + '\'' +
                ", ig_date=" + ig_date +
                ", ig_sum=" + ig_sum +
                ", ig_agree='" + ig_agree + '\'' +
                ", ig_person='" + ig_person + '\'' +
                '}';
    }
}
