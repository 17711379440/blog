package com.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:缩略图图片路径
 * @Author: liyong
 * @CreateDate: 2018/3/6 11:58
 * @Version: 1.0
 */
public class Thumbnail implements Serializable{
    private Integer id;
    //所属博客
    private Blog blog;
    //图片路经
    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getImageSrc() {
        return imagePath;
    }

    public void setImageSrc(String imagePath) {
        this.imagePath = imagePath;
    }
}
