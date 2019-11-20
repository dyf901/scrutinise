package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.BehaviorTypeDao;
import com.zty.scrutinise.entity.BehaviorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BehaviorTypeService {
    @Autowired
    private BehaviorTypeDao behaviorTypeDao;

    //分页查询行为类型信息
    public List<BehaviorType> find_behaviortype(Map map){
        return behaviorTypeDao.find_behaviortype(map);
    }

    //统计总条数
    public long total(){
        return behaviorTypeDao.total();
    }

    //增加行为类型信息
    public int add_behaviortype(Map map){
        return behaviorTypeDao.add_behaviortype(map);
    }

    //修改行为类型信息
    public int upd_behaviortype(Map map){
        return behaviorTypeDao.upd_behaviortype(map);
    }

    //删除行为类型信息
    public int del_behaviortype(Map map){
        return behaviorTypeDao.del_behaviortype(map);
    }

    //下拉框查询行为类型信息
    public List<BehaviorType> select_behaviortype(){
        return behaviorTypeDao.select_behaviortype();
    }
}
