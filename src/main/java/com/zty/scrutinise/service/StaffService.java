package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.StaffDao;
import com.zty.scrutinise.entity.Staff;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class StaffService {
    @Autowired
    private StaffDao staffDao;

    //实名认证
    public int attestation_staff(Map map){
        return staffDao.attestation_staff(map);
    }

    //分页查询员工信息(行查后台)
    public List<Staff> find_staff(Map map){
        return staffDao.find_staff(map);
    }

    //分页查询员工信息(企业后台)
    public List<Staff> find_staffPc(Map map){
        return staffDao.find_staffPc(map);
    }

    //修改个人资料_app
    public int upd_staff_app(Map map){
        return staffDao.upd_staff_app(map);
    }

    //统计总数(行查后台)
    public long total(){
        return staffDao.total();
    }

    //统计总数(企业后台)
    public long total_pc(Map map){
        return staffDao.total_pc(map);
    }

    //修改个人头像
    public int upd_staff_picture(Map map){
        return staffDao.upd_staff_picture(map);
    }

    //修改实名认证状态
    public int upd_status(Map map){
        return staffDao.upd_status(map);
    }

    //根据username查询某个员工信息
    public Staff find_staff_byusername(Map map){
        return staffDao.find_staff_byusername(map);
    }

    //根据sid查询用户信息
    public Staff find_staff_sid(Map map){
        return staffDao.find_staff_sid(map);
    }
}
