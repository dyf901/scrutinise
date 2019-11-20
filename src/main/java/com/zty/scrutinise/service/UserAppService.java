package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.UserAppDao;
import com.zty.scrutinise.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserAppService {
    @Autowired
    private UserAppDao userAppDao;

    //根据username查询登录账号信息
    public Object findByUsername(Map map){
        return userAppDao.findByUsername(map);
    }

    //保存验证码创建账号
    public int add_userapp(Map map){
        return userAppDao.add_userapp(map);
    }

    //修改验证码(如果验证码存在又重新发送)
    public int upd_code(Map map){
        return userAppDao.upd_code(map);
    }

    //注册账号(完善账号信息)
    public int complete_userapp(Map map){
        return userAppDao.complete_userapp(map);
    }

    //忘记密码
    public int forget_userapp(Map map){
        return userAppDao.forget_userapp(map);
    }
}
