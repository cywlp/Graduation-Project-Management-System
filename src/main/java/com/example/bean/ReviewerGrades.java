package com.example.bean;

import java.util.Date;

public class ReviewerGrades {
    Integer rg_id;
    Float  rg_investigate;
    Float rg_completion;
    Float rg_translation;
    Float rg_comprehension;
    Float rg_innovation;
    Float rg_design;
    String rg_comment;
    Date  rg_date;

    Float rg_sum;
    String rg_person;
    public ReviewerGrades() {
    }

    public Integer getRg_id() {
        return rg_id;
    }

    public void setRg_id(Integer rg_id) {
        this.rg_id = rg_id;
    }

    public Float getRg_investigate() {
        return rg_investigate;
    }

    public void setRg_investigate(Float rg_investigate) {
        this.rg_investigate = rg_investigate;
    }

    public Float getRg_completion() {
        return rg_completion;
    }

    public void setRg_completion(Float rg_completion) {
        this.rg_completion = rg_completion;
    }

    public Float getRg_translation() {
        return rg_translation;
    }

    public void setRg_translation(Float rg_translation) {
        this.rg_translation = rg_translation;
    }

    public Float getRg_comprehension() {
        return rg_comprehension;
    }

    public void setRg_comprehension(Float rg_comprehension) {
        this.rg_comprehension = rg_comprehension;
    }

    public Float getRg_innovation() {
        return rg_innovation;
    }

    public void setRg_innovation(Float rg_innovation) {
        this.rg_innovation = rg_innovation;
    }

    public Float getRg_design() {
        return rg_design;
    }

    public void setRg_design(Float rg_design) {
        this.rg_design = rg_design;
    }

    public String getRg_comment() {
        return rg_comment;
    }

    public void setRg_comment(String rg_comment) {
        this.rg_comment = rg_comment;
    }

    public Date getRg_date() {
        return rg_date;
    }

    public void setRg_date(Date rg_date) {
        this.rg_date = rg_date;
    }

    public Float getRg_sum() {
        return rg_sum;
    }

    public void setRg_sum(Float rg_sum) {
        this.rg_sum = rg_sum;
    }

    public String getRg_person() {
        return rg_person;
    }

    public void setRg_person(String rg_person) {
        this.rg_person = rg_person;
    }

    @Override
    public String toString() {
        return "ReviewerGrades{" +
                "rg_id=" + rg_id +
                ", rg_investigate=" + rg_investigate +
                ", rg_completion=" + rg_completion +
                ", rg_translation=" + rg_translation +
                ", rg_comprehension=" + rg_comprehension +
                ", rg_innovation=" + rg_innovation +
                ", rg_design=" + rg_design +
                ", rg_comment='" + rg_comment + '\'' +
                ", rg_date=" + rg_date +
                ", rg_sum=" + rg_sum +
                ", rg_person='" + rg_person + '\'' +
                '}';
    }
}
