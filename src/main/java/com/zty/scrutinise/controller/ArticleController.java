package com.zty.scrutinise.controller;

import com.zty.scrutinise.entity.Article;
import com.zty.scrutinise.page.Page;
import com.zty.scrutinise.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "新闻文章内容接口")
@RestController
@RequestMapping("article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "行差app后端分页查询文章信息",notes = "")
    @PostMapping("/find_article")
    public Page<Article> find_article(@RequestBody Map map){
        Page<Article> page=new Page<Article>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(articleService.total());
        page.setItems(articleService.find_article(map));
        return page;
    }

    @ApiOperation(value = "行差app根据类型查询文章内容",notes = "")
    @PostMapping("/find_article_type")
    public Page<Article> find_article_type(@RequestBody Map map){
        Page<Article> page=new Page<Article>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(articleService.total_type(map));
        page.setItems(articleService.find_article_type(map));
        return page;
    }

    @ApiOperation(value = "增加文章内容",notes = "")
    @PostMapping("/add_article")
    public boolean add_article(@RequestBody Map map){
        return articleService.add_article(map)==1;
    }

    @ApiOperation(value = "删除文章内容",notes = "")
    @PostMapping("/del_article")
    public boolean del_article(@RequestBody Map map){
        return articleService.del_article(map)==1;
    }

    @ApiOperation(value = "修改文章内容",notes = "")
    @PostMapping("/upd_article")
    public boolean upd_article(@RequestBody Map map){
        return articleService.upd_article(map)==1;
    }
}
