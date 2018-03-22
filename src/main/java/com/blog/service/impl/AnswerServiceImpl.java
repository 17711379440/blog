package com.blog.service.impl;

import com.blog.dao.AnswerDao;
import com.blog.entity.Answer;
import com.blog.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:51
 * @Version: 1.0
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDao answerDao;

    /**
     * 通过commentId查询评论
     *
     * @param id
     * @return
     */
    @Override
    public List<Answer> getAnswersById(Integer id) {
        return answerDao.getAnswersById(id);
    }

    /**
     * 通过回复Id查询评论信息
     *
     * @param id
     * @return
     */
    @Override
    public Answer getAnswerById(Integer id) {
        return answerDao.getAnswerById(id);
    }

    /**
     * 添加回复
     *
     * @param answer
     * @return
     */
    @Override
    public Boolean add(Answer answer) {
        return answerDao.add(answer) == 1;
    }

    /**
     * 删除回复
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Integer id) {
         answerDao.remove(id);
    }

    /**
     * 修改回复
     *
     * @param answer
     * @return
     */
    @Override
    public Integer update(Answer answer) {
        return answerDao.update(answer);
    }
}
