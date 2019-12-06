package com.zty.scrutinise.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "公司员工信息接口")
@RestController
@RequestMapping("companyperson")
@CrossOrigin
public class CompanypersonController {
}
