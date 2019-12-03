package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* 企业信息表实体类
*
* company   企业信息表
* id    企业id
* name   企业名称
* register_time   注册时间
* industry_id   行业类型id
* email    企业邮箱
* address   企业地址
* principal   企业负责人
* principal_phone      负责人联系电话
* principal_card     负责人身份证号
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company {
    private int id,industry_id;
    private String name,register_time,license,email,address,principal,principal_phone,principal_card;
    private String in_time,out_time;
    
    public Company(){
        super();
    }

    public Company(int id, int industry_id, String name, String register_time, String license, String email, String address, String principal, String principal_phone, String principal_card, String in_time, String out_time) {
        this.id = id;
        this.industry_id = industry_id;
        this.name = name;
        this.register_time = register_time;
        this.license = license;
        this.email = email;
        this.address = address;
        this.principal = principal;
        this.principal_phone = principal_phone;
        this.principal_card = principal_card;
        this.in_time = in_time;
        this.out_time = out_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndustry_id() {
        return industry_id;
    }

    public void setIndustry_id(int industry_id) {
        this.industry_id = industry_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipal_phone() {
        return principal_phone;
    }

    public void setPrincipal_phone(String principal_phone) {
        this.principal_phone = principal_phone;
    }

    public String getPrincipal_card() {
        return principal_card;
    }

    public void setPrincipal_card(String principal_card) {
        this.principal_card = principal_card;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", industry_id=" + industry_id +
                ", name='" + name + '\'' +
                ", register_time='" + register_time + '\'' +
                ", license='" + license + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", principal='" + principal + '\'' +
                ", principal_phone='" + principal_phone + '\'' +
                ", principal_card='" + principal_card + '\'' +
                ", in_time='" + in_time + '\'' +
                ", out_time='" + out_time + '\'' +
                '}';
    }
}
