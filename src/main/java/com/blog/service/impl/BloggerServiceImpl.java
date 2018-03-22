package com.blog.service.impl;

import com.blog.dao.BloggerDao;
import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:56
 * @Version: 1.0
 */
@Service
public class BloggerServiceImpl implements BloggerService {
    @Autowired
    private BloggerDao bloggerDao;
    /**
     * 查询博主
     *
     * @return 博主对象
     */
    @Override
    public Blogger getBlogger(String username) {
        return bloggerDao.get(username);
    }

    /**
     * 修改博主信息
     *
     * @param blogger
     * @return
     */
    @Override
    public Integer update(Blogger blogger) {
        return bloggerDao.update(blogger);
    }
}
