package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.CompanyDao;
import com.zty.scrutinise.dao.RegistrationDao;
import com.zty.scrutinise.entity.Company;
import com.zty.scrutinise.entity.Msg;
import com.zty.scrutinise.entity.Registration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

@Api(description = "打卡接口")
@RestController
@RequestMapping("registartion")
@CrossOrigin
public class RegistartionController {
    @Autowired
    private RegistrationDao registrationDao;

    @Autowired
    private CompanyDao companyDao;

    @ApiOperation(value = "测试",notes = "")
    @PostMapping("/text")
    public int text(@RequestBody Map map) throws ParseException {
        int s=TimeZone.getDefault().getRawOffset();
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
        System.out.println(current);
        System.out.println(zero);
        System.out.println(new Timestamp(current));//当前时间
        System.out.println(new Timestamp(yesterday));//昨天这一时间点
        System.out.println(new Timestamp(zero));//今天零点零分零秒
        System.out.println(new Timestamp(twelve));//今天23点59分59秒
        String strFormat = null;
        DateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String str = df.format(new Timestamp(zero));
        String s1 =df.format(new Timestamp(current));
        Company company=companyDao.find_worktime(map);//根据公司id查询公司上下班时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());//设置时间格式
        long in_time = simpleDateFormat.parse(company.getIn_time()).getTime();//把公司上班时间转换为毫秒数
        System.out.println("sss"+str);
        //Date d1 = (Date) simpleDateFormat.parse(company.getIn_time());
        //指定日期  
        Calendar cal = simpleDateFormat.getCalendar();
        int year =cal.get(Calendar.YEAR);//获取年份  
        int month =cal.get(Calendar.MONTH)+1;//获取月份  
        int day=cal.get(Calendar.DATE);//获取日  
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时  
        int minute=cal.get(Calendar.MINUTE);//分  
        int second=cal.get(Calendar.SECOND);//秒  
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天  
        System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日"+hour+":"+minute+":"+second+"     星期"+WeekOfYear);
        String sss=hour+":"+minute+":"+second;
        System.out.println(sss);
        System.out.println(company.getIn_time());
        if(df.parse(s1).getTime() > df.parse(sss).getTime()){
            System.out.println("大于");
        }else {
            System.out.println("小于");
        }
        return s;
    }

    @ApiOperation(value = "员工签到",notes = "")
    @PostMapping("/add_registartion")
    public Msg add_registartion(@RequestBody Map map) throws ParseException {
        Msg msg=new Msg();
        Registration registration=new Registration();
        registration.setCid((Integer) map.get("cid"));
        registration.setSid((Integer) map.get("sid"));
        registration.setIn_address((String) map.get("in_address"));
        Company company=companyDao.find_worktime(map);//根据公司id查询公司上下班时间
        DateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());//设置时间格式
        long in_time = simpleDateFormat.parse(company.getIn_time()).getTime();//把公司上班时间转换为毫秒数
        Calendar cal = simpleDateFormat.getCalendar();
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时  
        int minute=cal.get(Calendar.MINUTE);//分  
        int second=cal.get(Calendar.SECOND);//秒  
        String sss=hour+":"+minute+":"+second;
        System.out.println("规定上班时间"+sss);
        String s1 =df.format(new Timestamp(current));
        System.out.println("打卡时间"+s1);
        System.out.println(current>zero);
        if(df.parse(s1).getTime() < df.parse(sss).getTime()&&current > zero){
            int s=registrationDao.add_registartion(registration);//添加打卡记录
            System.out.println(registration.getId());//输出最近添加的打卡记录id
            registrationDao.find_id(registration.getId());//通过返回的id查找记录
            System.out.println(registrationDao.find_id(registration.getId()));//输出查看
            msg.setData(registrationDao.find_id(registration.getId()));//放入返回数组里面保存传给前台
            msg.setMessage("签到成功");
            return msg;
        }else {
            int s=registrationDao.add_registartion(registration);
            System.out.println("sass:"+registration.getId());
            registrationDao.find_id(registration.getId());
            System.out.println(registrationDao.find_id(registration.getId()));
            msg.setData(registrationDao.find_id(registration.getId()));
            msg.setMessage("迟到");
            return msg;
        }
    }

    @ApiOperation(value = "员工签退",notes = "")
    @PostMapping("/upd_registartion")
    public Msg upd_registartion(@RequestBody Map map) throws ParseException {
        Msg msg=new Msg();
        Registration registration=new Registration();
        registration.setCid((Integer) map.get("id"));
        registration.setIn_address((String) map.get("out_address"));
        Company company=companyDao.find_worktime(map);//根据公司id查询公司上下班时间
        DateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());//设置时间格式
        long in_time = simpleDateFormat.parse(company.getOut_time()).getTime();//把公司上班时间转换为毫秒数
        Calendar cal = simpleDateFormat.getCalendar();
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时  
        int minute=cal.get(Calendar.MINUTE);//分  
        int second=cal.get(Calendar.SECOND);//秒  
        String sss=hour+":"+minute+":"+second;
        System.out.println("规定下班时间"+sss);
        String s1 =df.format(new Timestamp(current));
        System.out.println("打卡时间"+s1);
        System.out.println(current>zero);
        if(df.parse(s1).getTime() > df.parse(sss).getTime()&&current < twelve){
            registrationDao.upd_registartion(registration);//签退
            msg.setData(registrationDao.find_id(registration.getId()));
            msg.setMessage("签退成功");
            return msg;
        }else {
            registrationDao.upd_registartion(registration);
            msg.setData(registrationDao.find_id(registration.getId()));
            msg.setMessage("早退");
            return msg;
        }
    }

}
