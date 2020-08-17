package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 行为记录表实体类
 *
 * behavior_record   行为记录表
 * id   行为记录id
 * bid   行为类型id
 * sid   员工id
 * cid   企业id
 * uptime   上传时间
 * integral   积分
 * particular   详细说明
 *
 * company_name  公司名称
 * company_abbreviation   公司简称
 * statistics   统计数据a
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BehaviorRecord {
    private int id, bid, sid, cid;
    private String uptime, integral, particular, PViews;
    private String behavior_name, staff_name, company_name, staff_sex, integral_up, integral_down, company_abbreviation;
    private int statistics;

    public BehaviorRecord() {
        super();
    }

    public BehaviorRecord(int id, int bid, int sid, int cid, String uptime, String integral, String particular, String PViews, String behavior_name, String staff_name, String company_name, String staff_sex, String integral_up, String integral_down, String company_abbreviation, int statistics) {
        this.id = id;
        this.bid = bid;
        this.sid = sid;
        this.cid = cid;
        this.uptime = uptime;
        this.integral = integral;
        this.particular = particular;
        this.PViews = PViews;
        this.behavior_name = behavior_name;
        this.staff_name = staff_name;
        this.company_name = company_name;
        this.staff_sex = staff_sex;
        this.integral_up = integral_up;
        this.integral_down = integral_down;
        this.company_abbreviation = company_abbreviation;
        this.statistics = statistics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getPViews() {
        return PViews;
    }

    public void setPViews(String PViews) {
        this.PViews = PViews;
    }

    public String getBehavior_name() {
        return behavior_name;
    }

    public void setBehavior_name(String behavior_name) {
        this.behavior_name = behavior_name;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getStaff_sex() {
        return staff_sex;
    }

    public void setStaff_sex(String staff_sex) {
        this.staff_sex = staff_sex;
    }

    public String getIntegral_up() {
        return integral_up;
    }

    public void setIntegral_up(String integral_up) {
        this.integral_up = integral_up;
    }

    public String getIntegral_down() {
        return integral_down;
    }

    public void setIntegral_down(String integral_down) {
        this.integral_down = integral_down;
    }

    public int getStatistics() {
        return statistics;
    }

    public void setStatistics(int statistics) {
        this.statistics = statistics;
    }

    public String getCompany_abbreviation() {
        return company_abbreviation;
    }

    public void setCompany_abbreviation(String company_abbreviation) {
        this.company_abbreviation = company_abbreviation;
    }

    @Override
    public String toString() {
        return "BehaviorRecord{" +
                "id=" + id +
                ", bid=" + bid +
                ", sid=" + sid +
                ", cid=" + cid +
                ", uptime='" + uptime + '\'' +
                ", integral='" + integral + '\'' +
                ", particular='" + particular + '\'' +
                ", PViews='" + PViews + '\'' +
                ", behavior_name='" + behavior_name + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", staff_sex='" + staff_sex + '\'' +
                ", integral_up='" + integral_up + '\'' +
                ", integral_down='" + integral_down + '\'' +
                ", company_abbreviation='" + company_abbreviation + '\'' +
                ", statistics=" + statistics +
                '}';
    }
}
