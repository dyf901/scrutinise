package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.DepartmentDao;
import com.zty.scrutinise.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService implements DepartmentDao {
    @Autowired
    private DepartmentDao departmentDao;

    //分页模糊查询部门信息
    @Override
    public List<Department> find_department(Map map) {
        return departmentDao.find_department(map);
    }

    //统计总数
    @Override
    public long total(Map map) {
        return departmentDao.total(map);
    }

    //增加部门信息
    @Override
    public int add_department(Map map) {
        return departmentDao.add_department(map);
    }

    //修改部门信息
    @Override
    public int upd_department(Map map) {
        return departmentDao.upd_department(map);
    }

    //删除部门信息
    @Override
    public int del_department(Map map) {
        return departmentDao.del_department(map);
    }
}
