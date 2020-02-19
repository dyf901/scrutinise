package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Company;

import java.util.Map;

public interface CompanyDao {
    //根据公司id查询上下班时间
    Company find_worktime(Map map);

    //公司注册
    int add_company(Map map);

    //登录
    Company login(Map map);

    //根据公司id查询公司基本信息
    Company find_byid(Map map);

    //根据公司id修改企业上下班时间
    int upd_company_time(Map map);
}
