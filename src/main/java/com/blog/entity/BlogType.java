package com.blog.entity;

import java.io.Serializable;

/**
 * @Description:博文类型实体
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:14
 * @Version: 1.0
 */
public class BlogType implements Serializable{
    //编号
    private  Integer id;
    //类型名称
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BlogType{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
