package com.blog.service.impl;

import com.blog.dao.LinkDao;
import com.blog.entity.Link;
import com.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:59
 * @Version: 1.0
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkDao linkDao;

    /**
     * 查询所有链接
     *
     * @return
     */
    @Override
    public List<Link> getAll() {
        return linkDao.getAll();
    }

    /**
     * 通过链接id查询链接信息
     *
     * @param id
     * @return
     */
    @Override
    public Link getLinkById(Integer id) {
        return linkDao.getLinkById(id);
    }

    /**
     * 添加链接
     *
     * @param link
     * @return
     */
    @Override
    public Integer add(Link link) {
        return linkDao.add(link);
    }

    /**
     * 删除链接
     *
     * @param id
     * @return
     */
    @Override
    public Integer remove(Integer id) {
        return linkDao.remove(id);
    }

    /**
     * 修改链接
     *
     * @param link
     * @return
     */
    @Override
    public Integer update(Link link) {
        return linkDao.update(link);
    }
}
