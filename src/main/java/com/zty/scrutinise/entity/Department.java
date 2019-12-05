package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
/*
* 部门表实体类
* department   部门表
* id           部门id
* company_id   公司id
* department_name    部门名称
* department_number  部门编号
* department_person  部门负责人
* department_headphone  部门负责人电话
* department_percount   部门人数
* create_time   添加时间
* remake   备注
* state   状态
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    private int id,company_id,department_percount;
    private String department_name,department_number,department_person,department_headphone,create_time,state;

    public Department(){
        super();
    }

    public Department(int id, int company_id, int department_percount, String department_name, String department_number, String department_person, String department_headphone, String create_time, String state) {
        this.id = id;
        this.company_id = company_id;
        this.department_percount = department_percount;
        this.department_name = department_name;
        this.department_number = department_number;
        this.department_person = department_person;
        this.department_headphone = department_headphone;
        this.create_time = create_time;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_percount() {
        return department_percount;
    }

    public void setDepartment_percount(int department_percount) {
        this.department_percount = department_percount;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_number() {
        return department_number;
    }

    public void setDepartment_number(String department_number) {
        this.department_number = department_number;
    }

    public String getDepartment_person() {
        return department_person;
    }

    public void setDepartment_person(String department_person) {
        this.department_person = department_person;
    }

    public String getDepartment_headphone() {
        return department_headphone;
    }

    public void setDepartment_headphone(String department_headphone) {
        this.department_headphone = department_headphone;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", department_percount=" + department_percount +
                ", department_name='" + department_name + '\'' +
                ", department_number='" + department_number + '\'' +
                ", department_person='" + department_person + '\'' +
                ", department_headphone='" + department_headphone + '\'' +
                ", create_time='" + create_time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
