package com.blog.dao;

import com.blog.entity.Blog;
import com.blog.entity.IndexInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:47
 * @Version: 1.0
 */
public interface BlogDao {
    /**
     * 查询所有博文
     * @return 所有博文
     */
    List<Blog> list(IndexInfo indexInfo);

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
    void add(Blog blog);

    /**
     * 删除博文
     * @param id 博文编号
     */
    void remove(Integer id);

    /**
     * 修改博文
     * @param blog
     * @return
     */
    void update(Blog blog);

    /**
     * 更新游览书或者评论数
     * @param flag
     * @param id
     */
    void updateNum(@Param("flag") Boolean flag,@Param("id") Integer id);
}
