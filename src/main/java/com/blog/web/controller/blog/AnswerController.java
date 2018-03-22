package com.blog.web.controller.blog;

import com.blog.entity.Answer;
import com.blog.entity.Comment;
import com.blog.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/30 13:05
 * @Version: 1.0
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @ResponseBody
    @RequestMapping(value = "revertComment", method = RequestMethod.POST)
    public Answer revertComment(Integer id, String content, Integer rid, String revertUserIp, HttpServletRequest request) {
        Comment comment = new Comment();
        comment.setId(id);
        Answer answer = new Answer();
        answer.setComment(comment);
        answer.setContent(content);
        answer.setUserIp(request.getRemoteAddr());
        Timestamp timestamp = new Timestamp(new Date().getTime());
        answer.setRevertDate(timestamp);
        answer.setRid(rid);
        answer.setRevertUserIp(revertUserIp);
        Boolean flag = answerService.add(answer);
        if (flag) {
            return answer;
        }
        return null;
    }

}
