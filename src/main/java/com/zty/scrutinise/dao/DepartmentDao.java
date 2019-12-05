package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {
    //分页模糊查询部门信息
    List<Department> find_department(Map map);

    //统计总数
    long total(Map map);

    //增加部门信息
    int add_department(Map map);

    //修改部门信息
    int upd_department(Map map);

    //删除部门信息
    int del_department(Map map);
}
