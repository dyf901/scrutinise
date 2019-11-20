package com.zty.scrutinise.controller;

import com.zty.scrutinise.dao.StaffDao;
import com.zty.scrutinise.entity.Staff;
import com.zty.scrutinise.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(description = "员工接口")
@RestController
@RequestMapping("staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffDao staffDao;

    @ApiOperation(value = "分页查询员工信息(行查后台)",notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("/find_staff")
    public Page<Staff> find_staff(@RequestBody Map map){
        Page<Staff> page=new Page<Staff>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(staffDao.find_staff(map));
        page.setTotal(staffDao.total());
        return page;
    }

    @ApiOperation(value = "分页查询员工信息(企业后台)",notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("/find_staffPc")
    public Page<Staff> find_staffPc(@RequestBody Map map){
        Page<Staff> page=new Page<Staff>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(staffDao.total_pc(map));
        page.setItems(staffDao.find_staffPc(map));
        return page;
    }

    @ApiOperation(value = "实名认证",notes = "")
    @PostMapping("/attestation_staff")
    public boolean attestation_staff(@RequestParam("files") MultipartFile[] files,Staff staff){
        Map map=new HashMap();
        map.put("sex",staff.getSex());
        map.put("card",staff.getCard());
        map.put("name",staff.getName());
        map.put("username",staff.getUsername());
        FileOutputStream fout =null;
        InputStream in =null;
        String path ="E:/Test/";
        try {
            int count=1;
            for (MultipartFile file : files) {
                //获取文件名
                String oldFileName = file.getOriginalFilename();
                //获取文件的后缀
                int lastDotIndex = oldFileName.lastIndexOf(".");
                String extName = oldFileName.substring(lastDotIndex);
                //判断文件后缀名
                if (extName.equals(".jpg")) {
                    extName=".jpg";
                }else if (extName.equals(".png")) {
                    extName=".png";
                }else if (extName.equals("jpeg")) {
                    extName=".jpg";
                }else{
                    extName=".jpg";
                }
                //拼成新名字
                String newName = path+UUID.randomUUID() + extName;

                String url=UUID.randomUUID() + extName;
                //这些if else是为了判断文件类型，并把文件名字存到实体类中去，并通过实体类存到数据库。
                if(count==1){
                    map.put("image_z",url);
                    System.out.println(map.get("image_z"));
                }else {
                    map.put("image_f",url);
                    System.out.println(map.get("image_f"));
                }

                fout =new FileOutputStream(new File(newName));//把文件保存到新的文件夹下，newName就是上面拼凑的新的文件夹名字
                //fout.write(file.getBytes());//这样做也可以
                in = file.getInputStream();
                int len;
                byte[] byt =new byte[1024];
                while ((len = in.read(byt)) != -1) {
                    fout.write(byt, 0, len);
                }
                //  如果使用上面的fout.write(file.getBytes());可以如下关闭流
                //  fout.close();
                //  in.close();
                count++;
            }
            return staffDao.attestation_staff(map)==1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != fout) {
                try {
                    fout.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                try {
                    in.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @ApiOperation(value = "查找员工照片", notes = "测试数据:{\"name\":\"安全行为之星系统.pdf\"}")
    @GetMapping("/find_img")
    public void find_img(@RequestParam String img_url, HttpServletResponse response) {
        try {
            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("E:\\Test\\" + img_url)));///root/img/
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

    @ApiOperation(value = "修改个人资料(App)",notes = "")
    @PostMapping("/upd_staff_app")
    public boolean upd_staff_app(@RequestBody Map map){
        return staffDao.upd_staff_app(map)==1;
    }

    @ApiOperation(value = "修改个人头像",notes = "")
    @PostMapping("/upd_staff_picture")
    public boolean upd_staff_picture(@RequestParam("file") MultipartFile file, Staff staff){
        Map map=new HashMap();
        map.put("username",staff.getUsername());
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        map.put("picture", newName);
        File excelFile =
                new File("E:\\Test\\"//   /root/img/
                        + newName);
        try {
            file.transferTo(excelFile);
            return staffDao.upd_staff_picture(map)==1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

