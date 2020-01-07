package com.zty.scrutinise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
/*
* 评论表实体类
* comment   评论表
* id     评论id
* aid    文章id
* sid    用户id
* content   评论内容
* uptime    评论时间
*
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment {
    private int id,aid,sid;
    private String content,uptime;

    public Comment(){
        super();
    }

    public Comment(int id, int aid, int sid, String content, String uptime) {
        this.id = id;
        this.aid = aid;
        this.sid = sid;
        this.content = content;
        this.uptime = uptime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
        return "Comment{" +
                "id=" + id +
                ", aid=" + aid +
                ", sid=" + sid +
                ", content='" + content + '\'' +
                ", uptime='" + uptime + '\'' +
                '}';
    }
}
