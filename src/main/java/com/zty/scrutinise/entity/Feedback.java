package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
/*
* 反馈信息表实体类
* feedback   反馈信息表
* id    反馈信息id
* content   反馈内容
* picture   反馈图片
* create_time   上传时间
* staff_id    用户id
* remake    备注
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feedback {
    private int id,staff_id;
    private String content,picture,create_time,remake;

    public Feedback(){
        super();
    }

    public Feedback(int id, int staff_id, String content, String picture, String create_time, String remake) {
        this.id = id;
        this.staff_id = staff_id;
        this.content = content;
        this.picture = picture;
        this.create_time = create_time;
        this.remake = remake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", create_time='" + create_time + '\'' +
                ", remake='" + remake + '\'' +
                '}';
    }
}
