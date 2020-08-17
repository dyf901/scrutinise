package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 职务表实体类
 * duty   职务表
 * id   职务id
 * duty_name   职务名称
 * department_id   部门id
 * remake   备注
 * state   状态
 *
 * department_name   部门名称
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Duty {
    private int id, department_id;
    private String duty_name, remake, state;
    private String department_name;

    public Duty() {
        super();
    }

    public Duty(int id, int department_id, String duty_name, String remake, String state, String department_name) {
        this.id = id;
        this.department_id = department_id;
        this.duty_name = duty_name;
        this.remake = remake;
        this.state = state;
        this.department_name = department_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDuty_name() {
        return duty_name;
    }

    public void setDuty_name(String duty_name) {
        this.duty_name = duty_name;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Duty{" +
                "id=" + id +
                ", department_id=" + department_id +
                ", duty_name='" + duty_name + '\'' +
                ", remake='" + remake + '\'' +
                ", state='" + state + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
