package com.blog.web.controller.blog;

import com.blog.entity.Blog;
import com.blog.entity.Comment;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/30 13:03
 * @Version: 1.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/publishComment", method = RequestMethod.POST)
    public Comment publishComment(Integer id, String commentStr, HttpServletRequest request) {
        Blog blog = new Blog();
        blog.setId(id);
        Comment comment = new Comment();
        comment.setBlog(blog);
        comment.setContent(commentStr);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        comment.setCommentDate(timestamp);
        comment.setUserIp(request.getRemoteAddr());
        Boolean flag = commentService.add(comment);

        if (flag) {
            blogService.updateNum(false,id);
            return comment;
        }
        return null;
    }
}
