package com.example.bean;

public class Pre_select {
    Integer s_id;
    Integer p_id;
    Integer pre_pri;
    Integer pre_success;

    Integer pre_id;

    public Pre_select() {
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getPre_pri() {
        return pre_pri;
    }

    public void setPre_pri(Integer pre_pri) {
        this.pre_pri = pre_pri;
    }

    public Integer getPre_success() {
        return pre_success;
    }

    public void setPre_success(Integer pre_success) {
        this.pre_success = pre_success;
    }

    public Integer getPre_id() {
        return pre_id;
    }

    public void setPre_id(Integer pre_id) {
        this.pre_id = pre_id;
    }

    @Override
    public String toString() {
        return "Pre_select{" +
                "s_id=" + s_id +
                ", p_id=" + p_id +
                ", pre_pri=" + pre_pri +
                ", pre_success=" + pre_success +
                ", pre_id=" + pre_id +
                '}';
    }
}
