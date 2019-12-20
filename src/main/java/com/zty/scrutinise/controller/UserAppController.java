package com.zty.scrutinise.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zty.scrutinise.dao.StaffDao;
import com.zty.scrutinise.dao.UserAppDao;
import com.zty.scrutinise.entity.Msg;
import com.zty.scrutinise.entity.Staff;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.zty.scrutinise.util.AliyunSmsUtils.sendSms;
import static com.zty.scrutinise.util.CodeUtil.getNewcode;
import static com.zty.scrutinise.util.CodeUtil.setNewcode;
import static com.zty.scrutinise.util.NickUtil.getNickname;
import static com.zty.scrutinise.util.NickUtil.setNickname;

@Api(description = "App注册登录接口")
@RestController
@RequestMapping("userApp")
@CrossOrigin
public class UserAppController {
    @Autowired
    private UserAppDao userAppDao;

    @ApiOperation(value = "登录",notes = "{\"username\":\"admin\",\n" +
            "\"password\":\"123456\"}")
    @PostMapping("/login")
    public Msg login(@RequestBody Map map) {
        System.out.println("账号:"+map.get("username"));
        Msg msg=new Msg();
        Staff staff=userAppDao.findByUsername(map);
        System.out.println("staff:"+staff);
        if (staff == null) {
            msg.setMessage("登录失败,用户不存在!");
            return msg;
        } else {
            if (staff.getPassword().equals(map.get("password"))) {
                msg.setData(staff);
                msg.setMessage("登录成功!");
                msg.setCode("200");
                return msg;
            } else {
                msg.setMessage("密码错误,登录失败!");
                return msg;
            }
        }
    }

    @ApiOperation(value = "获取验证码",notes = "")
    @PostMapping("/add_userapp")
    public Msg add_userapp(@RequestBody Map map) throws ClientException {
        Msg msg=new Msg();
        setNewcode();
        String code = Integer.toString(getNewcode());
        String phone=(String) map.get("username");
        SendSmsResponse response =sendSms(phone,code);
        System.out.println(response.getCode());
        map.put("code",code);
        Staff staff=userAppDao.findByUsername(map);
        System.out.println("1:"+staff);
        //判断账号是否存在
        if (staff==null){
            userAppDao.add_userapp(map);//不存在创建
        }else {
            userAppDao.upd_code(map);//存在修改code
        }
        //根据短信返回的Code判断短信发送结果
        if (response.getCode().equals("OK")){
            msg.setMessage("验证码已发送");
            return msg;
        }else if(response.getCode().equals("isv.MOBILE_NUMBER_ILLEGAL")){
            msg.setMessage("无效号码");
            return msg;
        }else {
            msg.setMessage("未知错误");
            return msg;
        }


    }

    @ApiOperation(value = "注册账号(完善账号信息)",notes = "")
    @PostMapping("/complete_userapp")
    public Msg complete_userapp(@RequestBody Map map){
        System.out.println(map);
        Msg msg=new Msg();
        setNickname();
        String nickname=getNickname();
        map.put("nickname",nickname);
        Staff staff=userAppDao.findByUsername(map);
        System.out.println("2:"+staff);
        if (staff!=null){
            if(staff.getCode().equals(map.get("code"))){
                userAppDao.complete_userapp(map);
                msg.setMessage("注册成功");
                return msg;
            }else{
                msg.setMessage("验证码错误");
                return msg;
            }
        }else {
            msg.setMessage("账号已注册");
            return msg;
        }

    }

    @ApiOperation(value = "忘记密码",notes = "")
    @PostMapping("forget_userapp")
    public Msg forget_userapp(@RequestBody Map map){
        Msg msg=new Msg();
        Staff staff=userAppDao.findByUsername(map);
        if(staff.getCode().equals(map.get("code"))){
            userAppDao.forget_userapp(map);
            msg.setMessage("修改成功");
            return msg;
        }else{
            msg.setMessage("验证码错误");
            return msg;
        }

    }

}
