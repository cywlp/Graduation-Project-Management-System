package com.example.bean;

public class FinalStudentProject {
    Integer t_id;
    String t_number;
    Integer id,projectId,ig_id,rg_id,dg_id;
    String number,name,major,projectName;

    public FinalStudentProject() {
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getIg_id() {
        return ig_id;
    }

    public void setIg_id(Integer ig_id) {
        this.ig_id = ig_id;
    }

    public Integer getRg_id() {
        return rg_id;
    }

    public void setRg_id(Integer rg_id) {
        this.rg_id = rg_id;
    }

    public Integer getDg_id() {
        return dg_id;
    }

    public void setDg_id(Integer dg_id) {
        this.dg_id = dg_id;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "FinalStudentProject{" +
                "t_id=" + t_id +
                ", t_number='" + t_number + '\'' +
                ", id=" + id +
                ", projectId=" + projectId +
                ", ig_id=" + ig_id +
                ", rg_id=" + rg_id +
                ", dg_id=" + dg_id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
