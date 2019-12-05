package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.DepartmentDao;
import com.zty.scrutinise.entity.Department;
import com.zty.scrutinise.page.Page;
import com.zty.scrutinise.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "部门接口")
@RestController
@RequestMapping("department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "分页模糊查询部门信息",notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("/find_department")
    public Page<Department> find_department(@RequestBody Map map){
        Page<Department> page=new Page<Department>();
        page.setPageSize((Integer) map.get("pageSize"));
        page.setPageNo((Integer) map.get("pageNo"));
        page.setTotal(departmentService.total(map));
        page.setItems(departmentService.find_department(map));
        return page;
    }

    @ApiOperation(value = "增加部门信息",notes = "{\"company_id\":1,\n" +
            "\"department_name\":\"开发部\",\n" +
            "\"department_number\":\"JT001\",\n" +
            "\"department_person\":\"晋铁\",\n" +
            "\"department_headphone\":\"13000000000\",\"remake\":\"晋铁智能科技开发人员部门\"}")
    @PostMapping("/add_department")
    public boolean add_department(@RequestBody Map map){
        return departmentService.add_department(map)==1;
    }

    @ApiOperation(value = "修改部门信息",notes = "{\"id\":1,\n" +
            "\"department_name\":\"开发部\",\n" +
            "\"department_number\":\"JT001\",\n" +
            "\"department_person\":\"晋铁1\",\n" +
            "\"department_headphone\":\"13000000000\",\"remake\":\"晋铁智能科技开发人员部门\"}")
    @PostMapping("/upd_department")
    public boolean upd_department(@RequestBody Map map){
        return departmentService.upd_department(map)==1;
    }

    @ApiOperation(value = "删除部门信息",notes = "{\"id\":1}")
    @PostMapping("/del_department")
    public boolean del_department(@RequestBody Map map){
        return departmentService.del_department(map)==1;
    }
}
