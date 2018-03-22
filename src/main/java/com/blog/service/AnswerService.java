package com.blog.service;

import com.blog.entity.Answer;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:48
 * @Version: 1.0
 */
public interface AnswerService {
    /**
     * 通过commentId查询评论
     * @param id
     * @return
     */
    List<Answer> getAnswersById(Integer id);

    /**
     * 通过回复Id查询评论信息
     * @param id
     * @return
     */
    Answer getAnswerById(Integer id);

    /**
     * 添加回复
     * @param answer
     * @return
     */
    Boolean add(Answer answer);

    /**
     * 删除回复
     * @param id
     * @return
     */
    void remove(Integer id);

    /**
     * 修改回复
     * @param answer
     * @return
     */
    Integer update(Answer answer);
}
