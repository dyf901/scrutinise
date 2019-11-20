package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* 行业类型表实体类
*
* industry_type   行业类型表
* id   行业类型id
* industry_name   行业类型名称
* state   状态
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndustryType {
    private int id;
    private String industry_name,state,remake;

    public IndustryType(){
        super();
    }

    public IndustryType(int id, String industry_name, String state, String remake) {
        this.id = id;
        this.industry_name = industry_name;
        this.state = state;
        this.remake = remake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndustry_name() {
        return industry_name;
    }

    public void setIndustry_name(String industry_name) {
        this.industry_name = industry_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    @Override
    public String toString() {
        return "IndustryType{" +
                "id=" + id +
                ", industry_name='" + industry_name + '\'' +
                ", state='" + state + '\'' +
                ", remake='" + remake + '\'' +
                '}';
    }
}
