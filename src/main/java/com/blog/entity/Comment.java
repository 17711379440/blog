package com.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 评论实体
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:29
 * @Version: 1.0
 */
public class Comment implements Serializable {
    //编号
    private Integer id;
    //用户的ip
    private String userIp;
    //博文
    private Blog blog;
    //评论
    private String content;
    //评论时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date commentDate;

    private Integer no;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Comment{");
        sb.append("id=").append(id);
        sb.append(", userIp='").append(userIp).append('\'');
        sb.append(", blog=").append(blog);
        sb.append(", content='").append(content).append('\'');
        sb.append(", commentDate=").append(commentDate);
        sb.append(", no=").append(no);
        sb.append('}');
        return sb.toString();
    }
}
