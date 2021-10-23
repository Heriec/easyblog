package com.heriec.easyblogmaster.pojo;

import java.sql.Timestamp;

public class Pv {
    private Long id;
    private String countDate;
    private Long pv;
    private Long uid;

    public Pv() {
    }

    public Pv(Long id, String countDate, Long pv, Long uid) {
        this.id = id;
        this.countDate = countDate;
        this.pv = pv;
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountDate() {
        return countDate;
    }

    public void setCountDate(String countDate) {
        this.countDate = countDate;
    }

    public Long getPv() {
        return pv;
    }

    public void setPv(Long pv) {
        this.pv = pv;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Pv{" +
                "id=" + id +
                ", countDate=" + countDate +
                ", pv=" + pv +
                ", uid=" + uid +
                '}';
    }
}
