package com.zty.scrutinise.entity;

/*签到表实体类
 * registration   签到表
 * id      id
 * sid     员工id
 * cid     公司id
 * in_time    签到时间
 * in_address   签到地址
 * out_time   签退时间
 * out_address   签退地址
 * */
public class Registration {
    private int id,sid,cid;
    private String in_time,in_address,out_time,out_address,state;

    public Registration(){
        super();
    }

    public Registration(int id, int sid, int cid, String in_time, String in_address, String out_time, String out_address, String state) {
        this.id = id;
        this.sid = sid;
        this.cid = cid;
        this.in_time = in_time;
        this.in_address = in_address;
        this.out_time = out_time;
        this.out_address = out_address;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", sid=" + sid +
                ", cid=" + cid +
                ", in_time='" + in_time + '\'' +
                ", in_address='" + in_address + '\'' +
                ", out_time='" + out_time + '\'' +
                ", out_address='" + out_address + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
