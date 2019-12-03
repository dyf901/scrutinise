package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Registration;

import java.util.Map;

public interface RegistrationDao {
    //员工签到
    int add_registartion(Registration registration);

    //员工签退
    int upd_registartion(Map map);

    //根据id查询签到信息
    Registration find_id(int id);
}
