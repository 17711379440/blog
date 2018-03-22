package com.blog.service.impl;

import com.blog.dao.ThumbnailDao;
import com.blog.entity.Blog;
import com.blog.entity.Thumbnail;
import com.blog.service.ThumbnailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/3/6 12:05
 * @Version: 1.0
 */
@Service
public class ThumbnailServiceImpl implements ThumbnailService {
    @Autowired
    private ThumbnailDao thumbnailDao;
    /**
     * 添加缩略图
     *
     * @param
     * @return
     */
    @Override
    public boolean add(Thumbnail thumbnail) {
        return thumbnailDao.add(thumbnail) ==1;
    }

    /**
     * 根据博客id删除对应的缩略图
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Integer id) {
         thumbnailDao.remove(id);
    }

    @Override
    public List<Thumbnail> getThumbnailList(Integer id) {
        return thumbnailDao.get(id);
    }
}
