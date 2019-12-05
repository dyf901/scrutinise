package com.zty.scrutinise.controller;

import com.zty.scrutinise.entity.Duty;
import com.zty.scrutinise.page.Page;
import com.zty.scrutinise.service.DutyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "职务接口")
@RestController
@RequestMapping("duty")
@CrossOrigin
public class DutyController {
    @Autowired
    private DutyService dutyService;

    @ApiOperation(value = "分页模糊查询职务信息",notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("find_duty")
    public Page<Duty> find_duty(@RequestBody Map map){
        Page<Duty> page = new Page<Duty>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(dutyService.total(map));
        page.setItems(dutyService.find_duty(map));
        return page;
    }

    @ApiOperation(value = "增加职务信息",notes = "测试数据:{\"duty_name\":\"总经理\",\n" +
            "\"department_id\":1,\n" +
            "\"remake\":\"开发部总监\"}")
    @PostMapping("add_duty")
    public boolean add_duty(@RequestBody Map map){
        return dutyService.add_duty(map)==1;
    }

    @ApiOperation(value = "修改职务信息",notes = "测试数据:{\"duty_name\":\"总经理\",\n" +
            "\"remake\":\"开发部总经理\",\n" +
            "\"id\":1}")
    @PostMapping("upd_duty")
    public boolean upd_duty(@RequestBody Map map){
        return dutyService.upd_duty(map)==1;
    }

    @ApiOperation(value = "删除职务信息",notes = "测试数据:{\"id\":1}")
    @PostMapping("del_duty")
    public boolean del_duty(@RequestBody Map map){
        return dutyService.del_duty(map)==1;
    }

    @ApiOperation(value = "下拉框查询部门职务信息",notes = "测试数据:{\"department_id\":1}")
    @PostMapping("select_duty")
    public List<Duty> select_duty(@RequestBody Map map){
        return dutyService.select_duty(map);
    }
}
