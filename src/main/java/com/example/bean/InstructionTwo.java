package com.example.bean;

import java.util.Date;

public class InstructionTwo {
    Integer isid;
    Integer sid;
    String snumber;
    Integer tid;
    String tnumber;
    String content;
    Date time;
    Integer isFinished;

    public InstructionTwo() {
    }

    public Integer getIsid() {
        return isid;
    }

    public void setIsid(Integer isid) {
        this.isid = isid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
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

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public String toString() {
        return "InstructionTwo{" +
                "isid=" + isid +
                ", sid=" + sid +
                ", snumber='" + snumber + '\'' +
                ", tid=" + tid +
                ", tnumber='" + tnumber + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", isFinished=" + isFinished +
                '}';
    }
}

