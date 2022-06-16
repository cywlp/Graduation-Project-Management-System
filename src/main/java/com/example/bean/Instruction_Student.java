package com.example.bean;

import javax.xml.crypto.Data;
import java.util.Date;

public class Instruction_Student {
    String Sid;
    String content;
    Date time;

    public Instruction_Student() {
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
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
}
