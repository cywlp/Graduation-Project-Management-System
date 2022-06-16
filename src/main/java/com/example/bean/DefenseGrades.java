package com.example.bean;

import java.util.Date;

public class DefenseGrades {
    Integer dg_id;
    Float dg_innovation;
    Float dg_quality;
    Float dg_difficulty;
    Float dg_verbal;
    Float dg_defense;
    String dg_comment;

    Date dg_date;

    String  dg_person;
    Float dg_sum;

    public DefenseGrades(Integer dg_id, Float dg_innovation, Float dg_quality, Float dg_difficulty, Float dg_verbal, Float dg_defense, String dg_comment, Date dg_date, String dg_person, Float dg_sum) {
        this.dg_id = dg_id;
        this.dg_innovation = dg_innovation;
        this.dg_quality = dg_quality;
        this.dg_difficulty = dg_difficulty;
        this.dg_verbal = dg_verbal;
        this.dg_defense = dg_defense;
        this.dg_comment = dg_comment;
        this.dg_date = dg_date;
        this.dg_person = dg_person;
        this.dg_sum = dg_sum;
    }

    public Integer getDg_id() {
        return dg_id;
    }

    public void setDg_id(Integer dg_id) {
        this.dg_id = dg_id;
    }

    public Float getDg_innovation() {
        return dg_innovation;
    }

    public void setDg_innovation(Float dg_innovation) {
        this.dg_innovation = dg_innovation;
    }

    public Float getDg_quality() {
        return dg_quality;
    }

    public void setDg_quality(Float dg_quality) {
        this.dg_quality = dg_quality;
    }

    public Float getDg_difficulty() {
        return dg_difficulty;
    }

    public void setDg_difficulty(Float dg_difficulty) {
        this.dg_difficulty = dg_difficulty;
    }

    public Float getDg_verbal() {
        return dg_verbal;
    }

    public void setDg_verbal(Float dg_verbal) {
        this.dg_verbal = dg_verbal;
    }

    public Float getDg_defense() {
        return dg_defense;
    }

    public void setDg_defense(Float dg_defense) {
        this.dg_defense = dg_defense;
    }

    public String getDg_comment() {
        return dg_comment;
    }

    public void setDg_comment(String dg_comment) {
        this.dg_comment = dg_comment;
    }

    public Date getDg_date() {
        return dg_date;
    }

    public void setDg_date(Date dg_date) {
        this.dg_date = dg_date;
    }

    public String getDg_person() {
        return dg_person;
    }

    public void setDg_person(String dg_person) {
        this.dg_person = dg_person;
    }

    public Float getDg_sum() {
        return dg_sum;
    }

    public void setDg_sum(Float dg_sum) {
        this.dg_sum = dg_sum;
    }

    public DefenseGrades() {
    }
}
