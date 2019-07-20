package com.fhp.vipcenter.domain;

import java.util.Date;

public class Vip {

    private Integer id;
    private Integer userId;
    private Integer viplevel;
    private Date expire;

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", userId=" + userId +
                ", viplevel=" + viplevel +
                ", expire=" + expire +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getViplevel() {
        return viplevel;
    }

    public void setViplevel(Integer viplevel) {
        this.viplevel = viplevel;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
