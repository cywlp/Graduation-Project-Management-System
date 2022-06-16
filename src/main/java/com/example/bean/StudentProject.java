package com.example.bean;

public class StudentProject {
    Integer sp_id,p_id,s_id,rg_id,ig_id,dg_id;

    public StudentProject() {
    }

    public Integer getSp_id() {
        return sp_id;
    }

    public void setSp_id(Integer sp_id) {
        this.sp_id = sp_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getRg_id() {
        return rg_id;
    }

    public void setRg_id(Integer rg_id) {
        this.rg_id = rg_id;
    }

    public Integer getIg_id() {
        return ig_id;
    }

    public void setIg_id(Integer ig_id) {
        this.ig_id = ig_id;
    }

    public Integer getDg_id() {
        return dg_id;
    }

    public void setDg_id(Integer dg_id) {
        this.dg_id = dg_id;
    }

    @Override
    public String toString() {
        return "StudentProject{" +
                "sp_id=" + sp_id +
                ", p_id=" + p_id +
                ", s_id=" + s_id +
                ", rg_id=" + rg_id +
                ", ig_id=" + ig_id +
                ", dg_id=" + dg_id +
                '}';
    }
}
