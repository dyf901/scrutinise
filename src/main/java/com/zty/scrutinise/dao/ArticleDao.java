package com.zty.scrutinise.dao;

import com.zty.scrutinise.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
    //行差app后端分页查询文章信息
    List<Article> find_article(Map map);

    //行差app后端分页查询文章信息——统计总数
    long total();

    //行差app根据类型查询文章内容
    List<Article> find_article_type(Map map);

    //行差app根据类型查询文章内容——统计总数
    long total_type(Map map);

    //增加文章内容
    int add_article(Map map);

    //删除文章内容
    int del_article(Map map);

    //修改文章内容
    int upd_article(Map map);
}
