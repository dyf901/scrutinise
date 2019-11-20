package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* 管理端用户表实体类
*
* user   管理端用户表
* id   用户id
* username   用户账号
* password   账号密码
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private int id;
    private String username,password;

    public User(){
        super();
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
