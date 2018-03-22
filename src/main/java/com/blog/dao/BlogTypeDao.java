package com.blog.dao;

import com.blog.entity.BlogType;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:55
 * @Version: 1.0
 */
public interface BlogTypeDao {
    /**
     * 查询所有博文类型
     * @return 所有博文类型集合
     */
    List<BlogType> getAll();

    /**
     * 通过博文类型id查询博文类型
     * @param id
     * @return
     */
    BlogType getBlogTypeById(Integer id);
    /**
     * 增加博文类型
     * @param blogType
     * @return
     */
    Integer add(BlogType blogType);

    /**
     * 删除博文类型
     * @param id
     * @return
     */
    Integer remove(Integer id);

    /**
     * 修改博文类型
     * @param blogType
     * @return
     */
    Integer update(BlogType blogType);


}
