package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Staff;

import java.util.List;
import java.util.Map;

public interface StaffDao {
    //实名认证
    int attestation_staff(Map map);

    //分页查询员工信息(行查后台)
    List<Staff> find_staff(Map map);

    //分页查询员工信息(企业后台)
    List<Staff> find_staffPc(Map map);

    //修改个人资料_app
    int upd_staff_app(Map map);

    //统计总数(行查后台)
    long total();

    //统计总数(企业后台)
    long total_pc(Map map);

    //修改个人头像
    int upd_staff_picture(Map map);

    //修改实名认证状态
    int upd_status(Map map);

    //根据username查询某个员工信息
    Staff find_staff_byusername(Map map);

    //根据身份证号查询员工信息
    Staff find_staff_bycard(Map map);
}
