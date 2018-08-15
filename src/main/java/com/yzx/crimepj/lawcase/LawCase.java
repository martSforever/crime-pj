package com.yzx.crimepj.lawcase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class LawCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                         //唯一标识符
    private String type;                        //用户名
    private Date time;                          //案件创建时间
    private String location;                    //地点
    private String evidence;                    //证据
    private String Description;                 //描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public java.lang.String getLocation() {
        return location;
    }

    public void setLocation(java.lang.String location) {
        this.location = location;
    }

    public java.lang.String getEvidence() {
        return evidence;
    }

    public void setEvidence(java.lang.String evidence) {
        this.evidence = evidence;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
