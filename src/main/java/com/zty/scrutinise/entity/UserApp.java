package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* user_app表实体类
*
* user_app表
* id    id
* username   账号
* password   密码
* staff_id   员工id
* picture    头像
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserApp {
    private int id,staff_id;
    private String username,password,picture;

    public UserApp(){
        super();
    }

    public UserApp(int id, int staff_id, String username, String password, String picture) {
        this.id = id;
        this.staff_id = staff_id;
        this.username = username;
        this.password = password;
        this.picture = picture;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserApp{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
