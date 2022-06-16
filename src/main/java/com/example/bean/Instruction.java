package com.example.bean;

import java.util.Date;

public class Instruction {
    Integer is_id;
    Integer s_id;
    Integer t_id;
    String content;
    Date time;
    Integer is_finished;

    public Integer getIs_id() {
        return is_id;
    }

    public void setIs_id(Integer is_id) {
        this.is_id = is_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIs_finished() {
        return is_finished;
    }

    public void setIs_finished(Integer is_finished) {
        this.is_finished = is_finished;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "is_id=" + is_id +
                ", s_id=" + s_id +
                ", t_id=" + t_id +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", is_finished=" + is_finished +
                '}';
    }

    public Instruction() {
    }
}
