package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* 行为类型实体类
*
* behavior_type   行为类型表
* id   行为类型id
* behavior_name   行为类型名称
* state   状态
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BehaviorType {
    private int id;
    private String behavior_name,state,remake;

    public BehaviorType(){
        super();
    }

    public BehaviorType(int id, String behavior_name, String state, String remake) {
        this.id = id;
        this.behavior_name = behavior_name;
        this.state = state;
        this.remake = remake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBehavior_name() {
        return behavior_name;
    }

    public void setBehavior_name(String behavior_name) {
        this.behavior_name = behavior_name;
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
        return "BehaviorType{" +
                "id=" + id +
                ", behavior_name='" + behavior_name + '\'' +
                ", state='" + state + '\'' +
                ", remake='" + remake + '\'' +
                '}';
    }
}
