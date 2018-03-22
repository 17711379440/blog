package com.blog.entity;

import java.io.Serializable;

/**
 * @Description: 链接实体
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:43
 * @Version: 1.0
 */
public class Link implements Serializable {
    //编号
    private Integer id;
    //链接名称
    private String linkName;
    //链接地址
    private String linkUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Link{");
        sb.append("id=").append(id);
        sb.append(", linkName='").append(linkName).append('\'');
        sb.append(", linkUrl='").append(linkUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
