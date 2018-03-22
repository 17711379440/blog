package com.blog.service;

import com.blog.entity.Blogger;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:48
 * @Version: 1.0
 */
public interface BloggerService {
    /**
     * 通过用户名查询博主
     * @return 博主对象
     */
    Blogger getBlogger(String username);

    /**
     * 修改博主信息
     * @param blogger
     * @return
     */
    Integer update(Blogger blogger);
}
