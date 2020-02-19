package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.ArticleDao;
import com.zty.scrutinise.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService implements ArticleDao {
    @Autowired
    private ArticleDao articleDao;

    //行差app后端分页查询文章信息
    @Override
    public List<Article> find_article(Map map) {
        return articleDao.find_article(map);
    }

    //行差app后端分页查询文章信息——统计总数
    @Override
    public long total() {
        return articleDao.total();
    }

    //行差app根据类型查询文章内容
    @Override
    public List<Article> find_article_type(Map map) {
        return articleDao.find_article_type(map);
    }

    //行差app根据类型查询文章内容——统计总数
    @Override
    public long total_type(Map map) {
        return articleDao.total_type(map);
    }

    //增加文章内容
    @Override
    public int add_article(Map map) {
        return articleDao.add_article(map);
    }

    //删除文章内容
    @Override
    public int del_article(Map map) {
        return articleDao.del_article(map);
    }

    //修改文章内容
    @Override
    public int upd_article(Map map) {
        return articleDao.upd_article(map);
    }
}
