package com.blog.web.controller.blog;

import com.blog.entity.Answer;
import com.blog.entity.Blog;
import com.blog.entity.Comment;
import com.blog.entity.IndexInfo;
import com.blog.lucene.BlogIndex;
import com.blog.service.*;
import com.blog.web.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 14:16
 * @Version: 1.0
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private LinkService linkService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogTypeService blogTypeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private BlogIndex blogIndex;

    @RequestMapping("/home")
    public String index(IndexInfo indexInfo, Model model, HttpSession session) {
        session.setAttribute("linkList", linkService.getAll());
        model.addAttribute("blogList", blogService.list(indexInfo));
        session.setAttribute("blogTypeList", blogTypeService.getAll());
        session.setAttribute("dateList", blogService.dateList());
        return "blog/home";
    }

    @RequestMapping(value = "/pageList")
    @ResponseBody
    public PageInfo<Blog> pageList(IndexInfo indexInfo) {
        PageInfo<Blog> list = blogService.list(indexInfo);
        return list;
    }

    /**
     * 同过博文id查询博文的详细信息
     *
     * @param id    博文Id
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Integer id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        model.addAttribute("prevBlog", blogService.getBlogById(id - 1));
        model.addAttribute("nextBlog", blogService.getBlogById(id + 1));
        Map<Comment, List<Answer>> comments = new LinkedHashMap<>();

        List<Comment> list = commentService.getCommentsById(id);
        for (Comment comment : list) {
            comments.put(comment, answerService.getAnswersById(comment.getId()));
        }
        model.addAttribute("comments", comments);
        Blog blog = new Blog();
        blog.setId(id);
        blogService.updateNum(true, id);
        return "blog/detail";
    }

    @GetMapping("q")
    public String search(String q, Model model, Integer pageIndex,HttpSession session) throws Exception {
        if(!StringUtils.isEmpty(q)){
            List<Blog> list = blogIndex.searchBlog(q);
            session.setAttribute(Constant.RESULT_LIST, list);
        }
        pageIndex = pageIndex ==null || pageIndex < 0 ? 1 : pageIndex;
        List<Blog> list = (List<Blog>) session.getAttribute(Constant.RESULT_LIST);
        //处理总记录数，如果每页显示10大于总记录数，就去总记录数作为页大小，反之去记录数
        model.addAttribute("isPagination",list.size() > 10);
       Integer subIndex = list.size() < pageIndex * 10 ? list.size() : pageIndex * 10;
       list = list.subList((pageIndex-1) * 10,subIndex);

        model.addAttribute("q", q);
        model.addAttribute("pageIndex",pageIndex);
        model.addAttribute(Constant.RESULT_LIST,list);
        return "blog/q";
    }
}
