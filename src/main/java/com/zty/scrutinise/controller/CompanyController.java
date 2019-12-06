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
import java.util.Map;
import java.util.UUID;

@Api(description = "公司接口")
@RestController
@RequestMapping("company")
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "公司注册",notes = "")
    @PostMapping("add_company")
    public boolean add_company(@RequestParam("file") MultipartFile file, Company company) throws Exception,IOException{
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        company.setLicense(newName);
        File excelFile =
                new File("E:\\Test\\"//   /root/img/
                        + newName);
            file.transferTo(excelFile);
            int i=companyService.add_company(company);
            if (i==1){
                return true;
            }else {
                return false;
            }
    }

    @ApiOperation(value = "登录",notes = "{\"username\":\"admin\",\n" +
            "\"password\":\"123456\"}")
    @PostMapping("login")
    public Msg login(@RequestBody Map map){
        Msg msg=new Msg();
        Company company=companyService.login(map);
        if(company==null){
            msg.setMessage("登录失败,账号不存在!");
            return msg;
        }else {
            if(company.getPassword().equals(map.get("password"))){
                msg.setData(company);
                msg.setMessage("登录成功!");
                return msg;
            }else {
                msg.setMessage("登录失败,密码错误!");
                return msg;
            }
        }
    }
}
