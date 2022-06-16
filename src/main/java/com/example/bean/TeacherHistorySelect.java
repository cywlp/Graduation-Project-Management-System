package com.example.bean;

public class TeacherHistorySelect {
    Integer id;
    String number;
    Integer p_id;
    String name;
    String origin;
    String type;
    String content;
    String grade;
    String scale;

    public TeacherHistorySelect() {
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

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "TeacherHistorySelect{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", p_id=" + p_id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", grade='" + grade + '\'' +
                ", scale='" + scale + '\'' +
                '}';
    }
}
