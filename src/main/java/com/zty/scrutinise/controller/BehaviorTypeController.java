package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.BehaviorTypeDao;
import com.zty.scrutinise.entity.BehaviorType;
import com.zty.scrutinise.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "行为类型接口")
@RestController
@RequestMapping("behaviortype")
@CrossOrigin
public class BehaviorTypeController {
    @Autowired
    private BehaviorTypeDao behaviorTypeDao;

    @ApiOperation(value = "分页查询行为类型信息",notes = "")
    @PostMapping("/find_behaviortype")
    public Page<BehaviorType> find_behaviortype(@RequestBody Map map){
        Page<BehaviorType> page=new Page<BehaviorType>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(behaviorTypeDao.total());
        page.setItems(behaviorTypeDao.find_behaviortype(map));
        return page;
    }

    @ApiOperation(value = "增加行为类型信息",notes = "")
    @PostMapping("/add_behaviortype")
    public int add_behaviortype(@RequestBody Map map){
        return behaviorTypeDao.add_behaviortype(map);
    }

    @ApiOperation(value = "修改行为类型信息",notes = "")
    @PostMapping("/upd_behaviortype")
    public int upd_behaviortype(@RequestBody Map map){
        return behaviorTypeDao.upd_behaviortype(map);
    }

    @ApiOperation(value = "删除行为类型信息",notes = "")
    @PostMapping("/del_behaviortype")
    public int del_behaviortype(@RequestBody Map map){
        return behaviorTypeDao.del_behaviortype(map);
    }

    @ApiOperation(value = "下拉框查询行为类型信息",notes = "")
    @PostMapping("/select_behaviortype")
    public List<BehaviorType> select_behaviortype(){
        return behaviorTypeDao.select_behaviortype();
    }
}
