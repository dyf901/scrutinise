package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*签到表实体类
 * registration   签到表
 * id      id
 * cpid     企业员工id
 * cid     公司id
 * in_time    签到时间
 * in_address   签到地址
 * out_time   签退时间
 * out_address   签退地址
 *
 * asd    数量
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Registration {
    private int id, cpid, cid;
    private String in_time, in_address, out_time, out_address, state;
    private String company_name, remark;
    private int asd;

    public Registration() {
        super();
    }

    public Registration(int id, int cpid, int cid, String in_time, String in_address, String out_time, String out_address, String state, String company_name, String remark, int asd) {
        this.id = id;
        this.cpid = cpid;
        this.cid = cid;
        this.in_time = in_time;
        this.in_address = in_address;
        this.out_time = out_time;
        this.out_address = out_address;
        this.state = state;
        this.company_name = company_name;
        this.remark = remark;
        this.asd = asd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpid() {
        return cpid;
    }

    public void setCpid(int cpid) {
        this.cpid = cpid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getIn_address() {
        return in_address;
    }

    public void setIn_address(String in_address) {
        this.in_address = in_address;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getOut_address() {
        return out_address;
    }

    public void setOut_address(String out_address) {
        this.out_address = out_address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getAsd() {
        return asd;
    }

    public void setAsd(int asd) {
        this.asd = asd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", cpid=" + cpid +
                ", cid=" + cid +
                ", in_time='" + in_time + '\'' +
                ", in_address='" + in_address + '\'' +
                ", out_time='" + out_time + '\'' +
                ", out_address='" + out_address + '\'' +
                ", state='" + state + '\'' +
                ", company_name='" + company_name + '\'' +
                ", remark='" + remark + '\'' +
                ", asd=" + asd +
                '}';
    }
}
