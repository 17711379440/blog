package com.blog.dao;

import com.blog.entity.Blog;
import com.blog.entity.Thumbnail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:缩略图操作接口
 * @Author: liyong
 * @CreateDate: 2018/3/6 12:02
 * @Version: 1.0
 */
public interface ThumbnailDao {
    /**
     * 添加缩略图
     * @param
     * @return
     */
    Integer add(Thumbnail thumbnail);
    /**
     * 根据博客id删除对应的缩略图
     *
     * @param id
     */
    void remove(Integer id);

    List<Thumbnail> get(Integer id);
}
