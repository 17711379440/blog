package com.blog.service.impl;

import com.blog.dao.CommentDao;
import com.blog.entity.Comment;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:58
 * @Version: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    /**
     * 通过博文id查询评论
     *
     * @param id
     * @return
     */
    @Override
    public List<Comment> getCommentsById(Integer id) {
        return commentDao.getCommentsById(id);
    }

    /**
     * 通过评论Id查询评论信息
     *
     * @param id
     * @return
     */
    @Override
    public Comment getCommentById(Integer id) {
        return commentDao.getCommentById(id);
    }


    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @Override
    public Boolean add(Comment comment) {
        return commentDao.add(comment) == 1;
    }

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Integer id) {
         commentDao.remove(id);
    }

    /**
     * 修改评论
     *
     * @param comment
     * @return
     */
    @Override
    public Integer update(Comment comment) {
        return commentDao.update(comment);
    }
}
