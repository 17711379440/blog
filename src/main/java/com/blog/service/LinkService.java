package com.blog.service;

import com.blog.entity.Link;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:50
 * @Version: 1.0
 */
public interface LinkService {
    /**
     * 查询所有链接
     * @return
     */
    List<Link> getAll();

    /**
     * 通过链接id查询链接信息
     * @param id
     * @return
     */
    Link getLinkById(Integer id);

    /**
     * 添加链接
     * @param link
     * @return
     */
    Integer add(Link link);

    /**
     * 删除链接
     * @param id
     * @return
     */
    Integer remove(Integer id);

    /**
     * 修改链接
     * @param link
     * @return
     */
    Integer update(Link link);
}
