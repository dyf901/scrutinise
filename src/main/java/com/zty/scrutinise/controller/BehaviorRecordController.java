package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.BehaviorRecordDao;
import com.zty.scrutinise.dao.StaffDao;
import com.zty.scrutinise.entity.BehaviorRecord;
import com.zty.scrutinise.entity.Msg;
import com.zty.scrutinise.entity.Staff;
import com.zty.scrutinise.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "行为记录接口")
@RestController
@RequestMapping("behaviorrecord")
@CrossOrigin
public class BehaviorRecordController {
    @Autowired
    private BehaviorRecordDao behaviorRecordDao;

    @Autowired
    private StaffDao staffDao;

    @ApiOperation(value = "分页查询行为记录(行查后台)",notes = "")
    @PostMapping("/find_behaviorrecord")
    public Page<BehaviorRecord> find_behaviorrecord(@RequestBody Map map){
        Page<BehaviorRecord> page=new Page<BehaviorRecord>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(behaviorRecordDao.total());
        page.setItems(behaviorRecordDao.find_behaviorrecord(map));
        return page;
    }

    @ApiOperation(value = "分页查询行为记录(企业后台)",notes = "")
    @PostMapping("/find_behaviorrecord_q")
    public Page<BehaviorRecord> find_behaviorrecord_q(@RequestBody Map map){
        Page<BehaviorRecord> page=new Page<BehaviorRecord>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(behaviorRecordDao.total_q());
        page.setItems(behaviorRecordDao.find_behaviorrecord_q(map));
        return page;
    }

    @ApiOperation(value = "增加行为记录",notes = "")
    @PostMapping("/add_behaviorrecord")
    public boolean add_behaviorrecord(@RequestBody Map map){
        Staff staff=staffDao.find_staff_bycard(map);
        map.put("sid",staff.getId());
        map.put("PViews",(int) (Math.random() * 100));
        return behaviorRecordDao.add_behaviorrecord(map)==1;
    }

    @ApiOperation(value = "删除行为记录",notes = "")
    @PostMapping("/del_behaviorrecord")
    public boolean del_behaviorrecord(@RequestBody Map map){
        return behaviorRecordDao.del_behaviorrecord(map)==1;
    }

    @ApiOperation(value = "个人行为记录报告",notes = "")
    @PostMapping("/find_behaviorrecord_report")
    public Msg find_behaviorrecord_report(@RequestBody Map map){
        Msg msg=new Msg();
        msg.setData(behaviorRecordDao.find_record_detail(map));
        msg.setStatistics(behaviorRecordDao.find_record_statistics(map));
        System.out.println(behaviorRecordDao.find_record_statistics(map));
        return msg;
    }
}
