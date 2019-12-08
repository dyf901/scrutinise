package com.zty.scrutinise.dao;


import com.zty.scrutinise.entity.Company_person;

import java.util.List;
import java.util.Map;

public interface CompanypersonDao {
    //分页模糊查询公司员工信息
    List<Company_person> find_companyperson(Map map);

    //统计总数
    long total(Map map);

    //增加企业员工信息
    int add_companyperson(Map map);

    //修改企业员工信息
    int upd_companyperson(Map map);

    //修改在职状态
    int upd_state(Map map);

    //统计在职人数
    int count_state_z(Map map);

    //统计离职人数
    int count_state_l(Map map);
}
