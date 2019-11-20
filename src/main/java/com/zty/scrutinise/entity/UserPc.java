package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Param;

/**
 * 企业端用户表实体类
 * id   id
 * username   账号
 * password   密码
 * company_id  公司id
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPc {
    private int id,company_id;
    private String username,password;

    public UserPc(){
        super();
    }

    public UserPc(int id, int company_id, String username, String password) {
        this.id = id;
        this.company_id = company_id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
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
        return "UserPc{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
