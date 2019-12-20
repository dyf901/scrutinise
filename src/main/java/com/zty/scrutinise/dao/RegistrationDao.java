package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Registration;

import java.util.List;
import java.util.Map;

public interface RegistrationDao {
    //员工签到
    int add_registartion(Registration registration);

    //员工签退
    int upd_registartion(Registration registration);

    //根据id查询签到信息
    Registration find_id(int id);

    //查询某个用户的考勤状况(app显示饼图)
    List<Registration> find_bystate(Map map);
}
