package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.BehaviorType;
import com.zty.scrutinise.entity.IndustryType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndustryTypeDao {
    //分页查询行业类型信息
    List<IndustryType> find_industrytype(Map map);

    //统计总条数
    long total();

    //增加行业类型信息
    int add_industrytype(Map map);

    //修改行业类型信息
    int upd_industrytype(Map map);

    //删除行业类型信息
    int del_industrytype(Map map);

    //下拉框查询行业类型信息
    List<IndustryType> select_industrytype();
}
