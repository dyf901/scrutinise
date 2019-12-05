package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.DepartmentDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "部门接口")
@RestController
@RequestMapping("department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentDao;
}
