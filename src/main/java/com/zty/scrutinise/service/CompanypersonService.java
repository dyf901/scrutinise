package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.CompanypersonDao;
import com.zty.scrutinise.entity.Company_person;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanypersonService implements CompanypersonDao {
    @Autowired
    private CompanypersonDao companypersonDao;

    //分页模糊查询公司员工信息
    @Override
    public List<Company_person> find_companyperson(Map map) {
        return companypersonDao.find_companyperson(map);
    }

    //统计总数
    @Override
    public long total(Map map) {
        return companypersonDao.total(map);
    }

    //增加企业员工信息
    @Override
    public int add_companyperson(Map map) {
        return companypersonDao.add_companyperson(map);
    }

    //修改企业员工信息
    @Override
    public int upd_companyperson(Map map) {
        return companypersonDao.upd_companyperson(map);
    }

    //修改在职状态
    @Override
    public int upd_state(Map map) {
        return companypersonDao.upd_state(map);
    }

    //统计在职人数
    @Override
    public int count_state_z(Map map) {
        return companypersonDao.count_state_z(map);
    }

    //统计离职人数
    @Override
    public int count_state_l(Map map) {
        return companypersonDao.count_state_l(map);
    }

    @Override
    public Company_person find_company_person_card(Map map) {
        return companypersonDao.find_company_person_card(map);
    }
}
