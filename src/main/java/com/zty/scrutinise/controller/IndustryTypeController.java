package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.IndustryTypeDao;
import com.zty.scrutinise.entity.IndustryType;
import com.zty.scrutinise.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "行业类型接口")
@RestController
@RequestMapping("industrytype")
@CrossOrigin
public class IndustryTypeController {
    @Autowired
    private IndustryTypeDao industryTypeDao;

    @ApiOperation(value = "分页查询行为类型信息" , notes = "")
    @PostMapping("/find_industrytype")
    public Page<IndustryType> find_industrytype(@RequestBody Map map) {
        Page<IndustryType> page = new Page<IndustryType>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(industryTypeDao.total());
        page.setItems(industryTypeDao.find_industrytype(map));
        return page;
    }

    @ApiOperation(value = "增加行业类型信息" , notes = "")
    @PostMapping("/add_industrytype")
    public int add_industrytype(@RequestBody Map map) {
        return industryTypeDao.add_industrytype(map);
    }

    @ApiOperation(value = "修改行业类型信息" , notes = "")
    @PostMapping("/upd_industrytype")
    public int upd_industrytype(@RequestBody Map map) {
        return industryTypeDao.upd_industrytype(map);
    }

    @ApiOperation(value = "删除行业类型信息" , notes = "")
    @PostMapping("/del_industrytype")
    public int del_industrytype(@RequestBody Map map) {
        return industryTypeDao.del_industrytype(map);
    }

    @ApiOperation(value = "下拉框查询行业类型信息" , notes = "")
    @PostMapping("/select_industrytype")
    public List<IndustryType> select_industrytype() {
        return industryTypeDao.select_industrytype();
    }
}
