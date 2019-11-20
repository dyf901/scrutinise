package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.BehaviorRecord;
import com.zty.scrutinise.entity.Staff;

import java.util.List;
import java.util.Map;

public interface BehaviorRecordDao {
    //分页查询行为记录
    List<BehaviorRecord> find_behaviorrecord(Map map);

    //统计总数
    long total();

    //增加行为记录
    int add_behaviorrecord(Map map);

    //删除行为记录
    int del_behaviorrecord(Map map);

    //个人行为记录报告_行为明细
    List<BehaviorRecord> find_record_detail(Map map);

    //个人纪录报告_统计数据
    List<BehaviorRecord> find_record_statistics(Map map);
}
