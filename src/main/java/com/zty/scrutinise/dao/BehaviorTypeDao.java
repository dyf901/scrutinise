package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.BehaviorType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BehaviorTypeDao {
    //分页查询行为类型信息
    List<BehaviorType> find_behaviortype(Map map);

    //统计总条数
    long total();

    //增加行为类型信息
    int add_behaviortype(Map map);

    //修改行为类型信息
    int upd_behaviortype(Map map);

    //删除行为类型信息
    int del_behaviortype(Map map);

    //下拉框查询行为类型信息
    List<BehaviorType> select_behaviortype();
}
