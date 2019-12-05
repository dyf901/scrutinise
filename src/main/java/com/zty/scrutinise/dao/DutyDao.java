package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Duty;

import java.util.List;
import java.util.Map;

public interface DutyDao {
    //分页模糊查询职务信息
    List<Duty> find_duty(Map map);

    //统计总数
    long total(Map map);

    //增加职务信息
    int add_duty(Map map);

    //修改职务信息
    int upd_duty(Map map);

    //删除职务信息
    int del_duty(Map map);

    //下拉框查询部门职务信息
    List<Duty> select_duty(Map map);
}
