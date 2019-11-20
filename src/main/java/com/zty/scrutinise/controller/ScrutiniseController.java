package com.zty.scrutinise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "测试")
@RestController
@RequestMapping("background")
@CrossOrigin
public class ScrutiniseController {

    @ApiOperation(value = "测试",notes = "")
    @GetMapping("/find")
    public String find(){
        return "ok!";
    }
}
