package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * 文章表实体类
 * article   文章表
 *
 * id       文章id
 * type     文章种类
 * theme    文章主题
 * author   文章作者
 * content  文章内容
 * pageview 浏览量
 * uptime   上传时间
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
    private int id,pageview;
    private String type,theme,author,content,uptime;

    public Article(){
        super();
    }

    public Article(int id, int pageview, String type, String theme, String author, String content, String uptime) {
        this.id = id;
        this.pageview = pageview;
        this.type = type;
        this.theme = theme;
        this.author = author;
        this.content = content;
        this.uptime = uptime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageview() {
        return pageview;
    }

    public void setPageview(int pageview) {
        this.pageview = pageview;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", pageview=" + pageview +
                ", type='" + type + '\'' +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", uptime='" + uptime + '\'' +
                '}';
    }
}
