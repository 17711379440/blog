package com.blog.service;

import com.blog.entity.Blog;
import com.blog.entity.IndexInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:46
 * @Version: 1.0
 */
public interface BlogService {
    /**
     * 查询所有博文
     * @return 所有博文
     */
    PageInfo<Blog> list(IndexInfo indexInfo);

    /**
     * 根据关键字搜索博文
     * @param keyWord 关键字
     * @return
     */
    List<Blog> getBlogsByKeyWord(String keyWord);

    /**
     * 查询日期
     * @return
     */
    List<String> dateList();

    /**
     * 通过id查询博文
     * @param id
     * @return
     */
    Blog getBlogById(Integer id);

    /**
     * 添加博文
     * @param blog
     * @return 受影响的行数
     */
    boolean add(Blog blog);

    /**
     * 删除博文
     * @param id 博文编号
     * @return 受影响的行数
     */
    boolean remove(Integer id);

    /**
     * 修改博文
     * @param blog
     * @return
     */
    boolean update(Blog blog);

    /**
     * 更新游览书或者评论数
     * @param flag
     * @param id
     */
    void updateNum(@Param("flag") Boolean flag, @Param("id") Integer id);

    /**
     * 删除对应博客Id的缩略图
     * @param id
     */
    void removeFile(Integer id);
}
