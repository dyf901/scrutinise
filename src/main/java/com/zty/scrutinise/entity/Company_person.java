package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
/*
* 公司员工表实体类
* company_person   公司员工信息表
* id   公司员工id
* name   姓名
* sex    性别
* age    年龄
* card   身份证号
* phone  联系电话
* email  邮箱
* address   住址
* politics_status   政治面貌
* education   学历
* specialty   专业
* school   毕业院校
* marital_status   婚姻状态
* picture   照片
* department_id   部门id
* duty_id   职称id
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company_person {
    private int id,age,department_id,duty_id;
    private String name,sex,card,phone,email,address,politics_status,education,specialty,school,marital_status,picture;

    public Company_person(){
        super();
    }

    public Company_person(int id, int age, int department_id, int duty_id, String name, String sex, String card, String phone, String email, String address, String politics_status, String education, String specialty, String school, String marital_status, String picture) {
        this.id = id;
        this.age = age;
        this.department_id = department_id;
        this.duty_id = duty_id;
        this.name = name;
        this.sex = sex;
        this.card = card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.politics_status = politics_status;
        this.education = education;
        this.specialty = specialty;
        this.school = school;
        this.marital_status = marital_status;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDuty_id() {
        return duty_id;
    }

    public void setDuty_id(int duty_id) {
        this.duty_id = duty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPolitics_status() {
        return politics_status;
    }

    public void setPolitics_status(String politics_status) {
        this.politics_status = politics_status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Company_person{" +
                "id=" + id +
                ", age=" + age +
                ", department_id=" + department_id +
                ", duty_id=" + duty_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", card='" + card + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", politics_status='" + politics_status + '\'' +
                ", education='" + education + '\'' +
                ", specialty='" + specialty + '\'' +
                ", school='" + school + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
