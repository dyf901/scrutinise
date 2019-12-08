package com.zty.scrutinise.controller;

import com.zty.scrutinise.entity.Company_person;
import com.zty.scrutinise.page.Page;
import com.zty.scrutinise.service.CompanypersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.UUID;

@Api(description = "公司员工信息接口")
@RestController
@RequestMapping("companyperson")
@CrossOrigin
public class CompanypersonController {
    @Autowired
    private CompanypersonService companypersonService;

    @ApiOperation(value = "公司员工分页模糊查询",notes = "")
    @PostMapping("find_companyperson")
    public Page<Company_person> find_companyperson(@RequestBody Map map){
        Page<Company_person> page = new Page<Company_person>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(companypersonService.total(map));
        page.setItems(companypersonService.find_companyperson(map));
        return page;
    }

    @ApiOperation(value = "增加企业员工信息",notes = "")
    @PostMapping("add_companyperson")
    public boolean add_companyperson(@RequestBody Map map){
        return companypersonService.add_companyperson(map)==1;
    }

    @ApiOperation(value = "修改企业员工信息",notes = "")
    @PostMapping("upd_companyperson")
    public boolean upd_companyperson(@RequestBody Map map){
        return companypersonService.upd_companyperson(map)==1;
    }

    @ApiOperation(value = "修改企业员工在职状态")
    @PostMapping("upd_state")
    public boolean upd_state(@RequestBody Map map){
        return companypersonService.upd_state(map)==1;
    }

    @ApiOperation(value = "企业员工图片上传",notes = "")
    @PostMapping("picture")
    public String picture(@RequestParam("file") MultipartFile file) {
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        //String newName="http://localhost:8800/staff/find_img?img_url="+oldFileName;
        File excelFile =
                new File("E:\\Test\\"//   /root/img/
                        + newName);
        try {
            file.transferTo(excelFile);
            return newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    @ApiOperation(value = "查找企业员工照片", notes = "测试数据:{\"name\":\"安全行为之星系统.pdf\"}")
    @GetMapping("/find_picture")
    public void find_picture(@RequestParam String picture, HttpServletResponse response) {
        try {
            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("E:\\Test\\" + picture)));///root/img/
            int num;
            byte[] b = new byte[1024];

            while ((num = bis.read(b)) != -1) {
                response.getOutputStream().write(b, 0, num);
            }
            response.getOutputStream().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
