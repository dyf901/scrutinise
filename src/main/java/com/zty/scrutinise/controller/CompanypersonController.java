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

    @ApiOperation(value = "公司员工分页模糊查询",notes = "测试数据:{\"pageNo\":1,\"pageSize\":10}")
    @PostMapping("find_companyperson")
    public Page<Company_person> find_companyperson(@RequestBody Map map){
        Page<Company_person> page = new Page<Company_person>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(companypersonService.total(map));
        page.setItems(companypersonService.find_companyperson(map));
        return page;
    }

    @ApiOperation(value = "增加企业员工信息",notes = "测试数据:{\"name\":\"晋铁\",\n" +
            "\"sex\":\"男\",\n" +
            "\"age\":23,\n" +
            "\"card\":\"340111111111111111\",\n" +
            "\"phone\":\"13000000000\",\n" +
            "\"email\":\"1300000000@qq.com\",\n" +
            "\"address\":\"上海市静安区俞泾港路108号\",\n" +
            "\"politics_status\":\"党员\",\n" +
            "\"education\":\"本科\",\n" +
            "\"specialty\":\"信息技术\",\n" +
            "\"school\":\"上海交通大学\",\n" +
            "\"marital_status\":\"未婚\",\n" +
            "\"department_id\":1,\n" +
            "\"duty_id\":1}")
    @PostMapping("add_companyperson")
    public boolean add_companyperson(@RequestBody Map map){
        return companypersonService.add_companyperson(map)==1;
    }

    @ApiOperation(value = "修改企业员工信息",notes = "测试数据:{\"name\":\"晋铁1\", \"sex\":\"男\", \"age\":23, \"card\":\"340111111111111111\", \"phone\":\"13000000000\", \"email\":\"1300000000@qq.com\", \"address\":\"上海市静安区俞泾港路108号\", \"politics_status\":\"党员\", \"education\":\"本科\", \"specialty\":\"信息技术\", \"school\":\"上海交通大学\", \"marital_status\":\"未婚\", \"department_id\":1, \"duty_id\":1,\n" +
            "\"id\":1}")
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

    @ApiOperation(value = "查找企业员工照片", notes = "测试数据:{\"picture\":\"安全行为之星系统.pdf\"}")
    @GetMapping("/find_picture")
    public void find_picture(@RequestParam String picture, HttpServletResponse response) {
        try {
            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("/root/img/" + picture)));///root/img/
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

    @ApiOperation(value = "统计在职人数",notes = "")
    @PostMapping("count_state_z")
    public int count_state_z(@RequestBody Map map){
        return companypersonService.count_state_z(map);
    }

    @ApiOperation(value = "统计离职人数",notes = "")
    @PostMapping("count_state_l")
    public int count_state_l(@RequestBody Map map){
        return companypersonService.count_state_l(map);
    }
}
