package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.DutyDao;
import com.zty.scrutinise.entity.Duty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DutyService implements DutyDao {
    @Autowired
    private DutyDao dutyDao;

    //分页模糊查询职务信息
    @Override
    public List<Duty> find_duty(Map map) {
        return dutyDao.find_duty(map);
    }

    //统计总数
    @Override
    public long total(Map map) {
        return dutyDao.total(map);
    }

    //增加职务信息
    @Override
    public int add_duty(Map map) {
        return dutyDao.add_duty(map);
    }

    //修改职务信息
    @Override
    public int upd_duty(Map map) {
        return dutyDao.upd_duty(map);
    }

    //删除职务信息
    @Override
    public int del_duty(Map map) {
        return dutyDao.del_duty(map);
    }

    //下拉框查询部门职务信息
    @Override
    public List<Duty> select_duty(Map map) {
        return dutyDao.select_duty(map);
    }
}
