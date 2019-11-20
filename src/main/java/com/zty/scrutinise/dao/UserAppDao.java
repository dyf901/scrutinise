package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserAppDao {

    //根据username查询登录账号信息
    Staff findByUsername(Map map);

    //保存验证码创建账号
    int add_userapp(Map map);

    //修改验证码(如果验证码存在又重新发送)
    int upd_code(Map map);

    //注册账号(完善账号信息)
    int complete_userapp(Map map);

    //忘记密码
    int forget_userapp(Map map);
}
