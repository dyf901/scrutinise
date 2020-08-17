package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.CompanyDao;
import com.zty.scrutinise.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CompanyService implements CompanyDao {
    @Autowired
    private CompanyDao companyDao;

    //根据公司id查询上下班时间
    public Company find_worktime(Map map) {
        return companyDao.find_worktime(map);
    }

    //公司注册
    @Override
    public int add_company(Map map) {
        return companyDao.add_company(map);
    }

    //登录
    @Override
    public Company login(Map map) {
        return companyDao.login(map);
    }

    //根据公司id查询公司基本信息
    @Override
    public Company find_byid(Map map) {
        return companyDao.find_byid(map);
    }

    //根据公司id修改企业上下班时间
    @Override
    public int upd_company_time(Map map) {
        return companyDao.upd_company_time(map);
    }
}
