package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.IndustryTypeDao;
import com.zty.scrutinise.entity.IndustryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndustryTypeService {
    @Autowired
    private IndustryTypeDao industryTypeDao;

    //分页查询行业类型信息
    public List<IndustryType> find_industrytype(Map map){
        return industryTypeDao.find_industrytype(map);
    }

    //统计条数
    public long total(){
        return industryTypeDao.total();
    }

    //增加行业类型信息
    public int add_industrytype(Map map){
        return industryTypeDao.add_industrytype(map);
    }

    //修改行业类型信息
    public int upd_industrytype(Map map){
        return industryTypeDao.upd_industrytype(map);
    }

    //删除行业类型信息
    public int del_industrytype(Map map){
        return industryTypeDao.del_industrytype(map);
    }

    //下拉框行业类型信息
    public List<IndustryType> select_industrytype(){
        return industryTypeDao.select_industrytype();
    }
}
