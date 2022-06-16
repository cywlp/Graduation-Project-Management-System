package com.example.bean;

public class TeacherApplication {
    Integer t_id;
    String t_number;
    Integer id;
    String number;
    String name;
    String major;
    Integer projectId;
    String projectName;
    Integer status;

    public TeacherApplication() {
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_number() {
        return t_number;
    }

    public void setT_number(String t_number) {
        this.t_number = t_number;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeacherApplication{" +
                "t_id=" + t_id +
                ", t_number='" + t_number + '\'' +
                ", id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", status=" + status +
                '}';
    }
}
