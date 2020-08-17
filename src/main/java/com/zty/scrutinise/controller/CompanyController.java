package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.CompanyDao;
import com.zty.scrutinise.entity.Company;
import com.zty.scrutinise.entity.Msg;
import com.zty.scrutinise.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@Api(description = "公司接口")
@RestController
@RequestMapping("company")
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "公司注册" , notes = "")
    @PostMapping("add_company")
    public boolean add_company(@RequestBody Map map) {
        return companyService.add_company(map) == 1;
    }

    @ApiOperation(value = "登录" , notes = "{\"username\":\"admin\",\n" +
            "\"password\":\"123456\"}")
    @PostMapping("login")
    public Msg login(@RequestBody Map map) {
        Msg msg = new Msg();
        Company company = companyService.login(map);
        if (company == null) {
            msg.setMessage("登录失败,账号不存在!");
            return msg;
        } else {
            if (company.getPassword().equals(map.get("password"))) {
                msg.setData(company);
                msg.setMessage("登录成功!");
                return msg;
            } else {
                msg.setMessage("登录失败,密码错误!");
                return msg;
            }
        }
    }

    @ApiOperation(value = "营业执照上传" , notes = "")
    @PostMapping("upload")
    public String picture(@RequestParam("file") MultipartFile file) {
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        //String newName="http://localhost:8800/staff/find_img?img_url="+oldFileName;
        File excelFile =
                new File("/root/img/"//   /root/img/
                        + newName);
        try {
            file.transferTo(excelFile);
            return newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    @ApiOperation(value = "根据公司id查询公司基本信息" , notes = "")
    @PostMapping("find_byid")
    public Company find_byid(@RequestBody Map map) {
        return companyService.find_byid(map);
    }

    @ApiOperation(value = "根据公司id修改企业上下班时间" , notes = "")
    @PostMapping("upd_company_time")
    public boolean upd_company_time(@RequestBody Map map) throws ParseException {
        //上班时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" , Locale.getDefault());//设置时间格式
        long in_time = simpleDateFormat.parse((String) map.get("in_time")).getTime();//把公司上班时间转换为毫秒数
        Calendar cal = simpleDateFormat.getCalendar();
        int hour = cal.get(Calendar.HOUR_OF_DAY);//小时  
        int minute = cal.get(Calendar.MINUTE);//分
        //下班时间
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" , Locale.getDefault());//设置时间格式
        long out_time = simpleDateFormat1.parse((String) map.get("out_time")).getTime();//把公司上班时间转换为毫秒数
        Calendar cal1 = simpleDateFormat1.getCalendar();
        int hour1 = cal1.get(Calendar.HOUR_OF_DAY);//小时  
        int minute1 = cal1.get(Calendar.MINUTE);//分

        if (hour < 10 && minute < 10 && minute1 < 10) {
            System.out.println("0" + hour + ":" + "0" + minute + " ~ " + hour1 + ":" + "0" + minute1);
            String a = "0" + hour + ":" + "0" + minute + " ~ " + hour1 + ":" + "0" + minute1;
            map.put("shift" , a);
            System.out.println("1");
            return companyService.upd_company_time(map) == 1;

        } else if (hour >= 10 && minute < 10 && minute1 < 10) {
            System.out.println(hour + ":" + "0" + minute + " ~ " + hour1 + ":" + "0" + minute1);
            String a = hour + ":" + "0" + minute + " ~ " + hour1 + ":" + "0" + minute1;
            map.put("shift" , a);
            System.out.println("2");
            return companyService.upd_company_time(map) == 1;

        } else if (hour < 10 && minute >= 10 && minute1 < 10) {
            System.out.println("0" + hour + ":" + minute + " ~ " + hour1 + ":" + "0" + minute1);
            String a = "0" + hour + ":" + minute + " ~ " + hour1 + ":" + "0" + minute1;
            map.put("shift" , a);
            System.out.println("3");
            return companyService.upd_company_time(map) == 1;

        } else if (hour < 10 && minute < 10 && minute1 >= 10) {
            System.out.println("0" + hour + ":" + "0" + minute + " ~ " + hour1 + ":" + minute1);
            String a = "0" + hour + ":" + "0" + minute + " ~ " + hour1 + ":" + minute1;
            map.put("shift" , a);
            System.out.println("4");
            return companyService.upd_company_time(map) == 1;

        } else if (hour >= 10 && minute >= 10 && minute1 < 10) {
            System.out.println(hour + ":" + minute + " ~ " + hour1 + ":" + "0" + minute1);
            String a = hour + ":" + minute + " ~ " + hour1 + ":" + "0" + minute1;
            map.put("shift" , a);
            System.out.println("5");
            return companyService.upd_company_time(map) == 1;

        } else if (hour >= 10 && minute >= 10 && minute1 >= 10) {
            System.out.println(hour + ":" + minute + " ~ " + hour1 + ":" + minute1);
            String a = hour + ":" + minute + " ~ " + hour1 + ":" + minute1;
            map.put("shift" , a);
            System.out.println("6");
            return companyService.upd_company_time(map) == 1;

        } else if (hour < 10 && minute >= 10 && minute1 >= 10) {
            System.out.println("0" + hour + ":" + minute + " ~ " + hour1 + ":" + minute1);
            String a = "0" + hour + ":" + minute + " ~ " + hour1 + ":" + minute1;
            map.put("shift" , a);
            System.out.println("7");
            return companyService.upd_company_time(map) == 1;

        } else if (hour >= 10 && minute < 10 && minute1 >= 10) {
            System.out.println(hour + ":" + "0" + minute + " ~ " + hour1 + ":" + minute1);
            String a = hour + ":" + "0" + minute + " ~ " + hour1 + ":" + minute1;
            map.put("shift" , a);
            System.out.println("8");
            return companyService.upd_company_time(map) == 1;
        } else {
            return false;
        }
    }
}
