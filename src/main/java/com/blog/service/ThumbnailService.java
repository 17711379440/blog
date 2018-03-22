package com.blog.service;

import com.blog.entity.Thumbnail;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/3/6 12:04
 * @Version: 1.0
 */
public interface ThumbnailService {
    /**
     * 添加缩略图
     * @param
     * @return
     */
    boolean add(Thumbnail thumbnail);

    /**
     * 根据博客id删除对应的缩略图
     * @param id
     * @return
     */
    void remove(Integer id);


    List<Thumbnail> getThumbnailList(Integer id);
}
