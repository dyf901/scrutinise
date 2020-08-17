package com.zty.scrutinise.controller;

import com.zty.scrutinise.entity.Msg;
import com.zty.scrutinise.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Api(description = "反馈信息接口")
@RestController
@RequestMapping("feedback")
@CrossOrigin
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "增加反馈信息" , notes = "")
    @PostMapping("add_feedback")
    public Msg add_feedback(@RequestBody Map map) {
        Msg msg = new Msg();
        int i = feedbackService.add_feedback(map);
        if (i == 1) {
            msg.setMessage("提交成功!");
            return msg;
        } else {
            msg.setMessage("提交失败!");
            return msg;
        }
    }

    @ApiOperation(value = "反馈图片" , notes = "")
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
}
