package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* 员工信息表实体类
*
* staff   员工信息表
* id   员工id
* name   员工姓名
* age    年龄
* card   身份证号
* phone   手机号
* company_id   所在公司id
* integral_up      正积分
* integral_down     负积分
* username     账号
* password      密码
* image_z     实名认证图片正面
* image_f     实名认证图片反面
* picture      头像
* nickname    昵称
* signature     个性签名
* code      验证码
* status     实名认证状态
* state   在职状态
* clockstatus   打卡状态
* */
public class Staff {
    private int id,company_id,age;
    private String name,sex,card,state;
    private int integral_up,integral_down;
    private String company_name,address;
    private String password,picture,nickname,signature,code,status;
    private String username,phone,clockstatus,abbreviation;

    public Staff(){
        super();
    }

    public Staff(int id, int company_id, int age, String name, String sex, String card, String state, int integral_up, int integral_down, String company_name, String address, String password, String picture, String nickname, String signature, String code, String status, String username, String phone, String clockstatus, String abbreviation) {
        this.id = id;
        this.company_id = company_id;
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.card = card;
        this.state = state;
        this.integral_up = integral_up;
        this.integral_down = integral_down;
        this.company_name = company_name;
        this.address = address;
        this.password = password;
        this.picture = picture;
        this.nickname = nickname;
        this.signature = signature;
        this.code = code;
        this.status = status;
        this.username = username;
        this.phone = phone;
        this.clockstatus = clockstatus;
        this.abbreviation = abbreviation;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIntegral_up() {
        return integral_up;
    }

    public void setIntegral_up(int integral_up) {
        this.integral_up = integral_up;
    }

    public int getIntegral_down() {
        return integral_down;
    }

    public void setIntegral_down(int integral_down) {
        this.integral_down = integral_down;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClockstatus() {
        return clockstatus;
    }

    public void setClockstatus(String clockstatus) {
        this.clockstatus = clockstatus;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", card='" + card + '\'' +
                ", state='" + state + '\'' +
                ", integral_up=" + integral_up +
                ", integral_down=" + integral_down +
                ", company_name='" + company_name + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", nickname='" + nickname + '\'' +
                ", signature='" + signature + '\'' +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", clockstatus='" + clockstatus + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
