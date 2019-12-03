package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Company;

import java.util.Map;

public interface CompanyDao {
    //根据公司id查询上下班时间
    Company find_worktime(Map map);
}
