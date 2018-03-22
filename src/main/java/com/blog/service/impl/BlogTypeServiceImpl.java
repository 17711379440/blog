package com.blog.service.impl;

import com.blog.dao.BlogTypeDao;
import com.blog.entity.BlogType;
import com.blog.entity.IndexInfo;
import com.blog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:58
 * @Version: 1.0
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    private BlogTypeDao blogTypeDao;

    /**
     * 查询所有博文类型
     *
     * @return 所有博文类型集合
     */
    @Override
    public List<BlogType> getAll() {
        return blogTypeDao.getAll();
    }

    /**
     * 通过博文类型id查询博文类型
     *
     * @param id
     * @return
     */
    @Override
    public BlogType getBlogTypeById(Integer id) {
        return blogTypeDao.getBlogTypeById(id);
    }

    /**
     * 增加博文类型
     *
     * @param blogType
     * @return
     */
    @Override
    public boolean add(BlogType blogType) {
        return blogTypeDao.add(blogType) == 1;
    }

    /**
     * 删除博文类型
     *
     * @param id
     * @return
     */
    @Override
    public boolean remove(Integer id) {
        return blogTypeDao.remove(id) == 1;
    }

    /**
     * 修改博文类型
     *
     * @param blogType
     * @return
     */
    @Override
    public boolean update(BlogType blogType) {
        return blogTypeDao.update(blogType) == 1;
    }
}
