package com.heriec.easyblogmaster.pojo;

import java.sql.Timestamp;

public class Category {
    private Long id;
    private String cateName;
    private Timestamp date;

    public Category() {
    }
    public Category(Long id, String cateName, Timestamp date) {
        this.id = id;
        this.cateName = cateName;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cateName='" + cateName + '\'' +
                ", date=" + date +
                '}';
    }
}
