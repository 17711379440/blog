package com.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 回复实体
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:39
 * @Version: 1.0
 */
public class Answer implements Serializable {
    //编号
    private Integer id;
    //用户Ip
    private String userIp;
    //评论对象
    private Comment comment;
    //回复内容
    private String content;
    //回复时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date revertDate;
    //回复id
    private Integer rid;
    //被回复的Ip
    private String revertUserIp;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Date getRevertDate() {
        return revertDate;
    }

    public void setRevertDate(Date revertDate) {
        this.revertDate = revertDate;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRevertUserIp() {
        return revertUserIp;
    }

    public void setRevertUserIp(String revertUserIp) {
        this.revertUserIp = revertUserIp;
    }
}
