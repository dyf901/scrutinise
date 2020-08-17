package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.BehaviorRecordDao;
import com.zty.scrutinise.entity.BehaviorRecord;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BehaviorRecordService {
    @Autowired
    private BehaviorRecordDao behaviorRecordDao;

    //分页查询行为记录
    public List<BehaviorRecord> find_behaviorrecord(Map map) {
        return behaviorRecordDao.find_behaviorrecord(map);
    }

    //统计总数
    public long total() {
        return behaviorRecordDao.total();
    }

    //增加行为记录
    public int add_behaviorrecord(Map map) {
        return behaviorRecordDao.add_behaviorrecord(map);
    }

    //删除行为记录
    public int del_behaviorrecord(Map map) {
        return behaviorRecordDao.del_behaviorrecord(map);
    }

    //个人行为记录报告_行为明细
    public List<BehaviorRecord> find_record_detail(Map map) {
        return behaviorRecordDao.find_record_detail(map);
    }

    //个人纪录报告_统计数据
    public List<BehaviorRecord> find_record_statistics(Map map) {
        return behaviorRecordDao.find_record_statistics(map);
    }
}
