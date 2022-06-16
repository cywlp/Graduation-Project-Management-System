package com.example.bean;

public class StudentApplication {
    String number;
    Integer projectId;
    String projectName;
    Integer status;

    public StudentApplication() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "StudentApplication{" +
                "number='" + number + '\'' +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", status=" + status +
                '}';
    }
}
