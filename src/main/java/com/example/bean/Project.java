package com.example.bean;

public class Project {
    private Integer p_id;
    private String p_name;
    private String p_origin;
    private String p_type;

    private String p_content;

    @Override
    public String toString() {
        return "Project{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_origin='" + p_origin + '\'' +
                ", p_type='" + p_type + '\'' +
                ", p_content='" + p_content + '\'' +
                '}';
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public Project() {
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_origin() {
        return p_origin;
    }

    public void setP_origin(String p_origin) {
        this.p_origin = p_origin;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

}
