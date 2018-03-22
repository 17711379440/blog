package com.blog.dao;

import com.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:56
 * @Version: 1.0
 */
public interface CommentDao {
    /**
     * 通过博文id查询评论
     * @param id
     * @return
     */
    List<Comment> getCommentsById(Integer id);

    /**
     * 通过评论Id查询评论信息
     * @param id
     * @return
     */
    Comment getCommentById(Integer id);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    Integer add(Comment comment);

    /**
     * 删除评论
     * @param id
     */
    void remove(Integer id);

    /**
     * 修改评论
     * @param comment
     * @return
     */
    Integer update(Comment comment);
}
