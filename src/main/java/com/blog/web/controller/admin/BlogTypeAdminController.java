package com.blog.web.controller.admin;

import com.blog.entity.BlogType;
import com.blog.service.BlogTypeService;
import com.blog.web.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 博客类别管理员控制类
 * @Author: liyong
 * @CreateDate: 2018/3/18 10:45
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
    @Autowired
    private BlogTypeService blogTypeService;

    /**
     * 导航到博客类别页面
     *
     * @return
     */
    @GetMapping("blogTypeManager")
    public String blogTypeManager() {
        return "admin/blogTypeManager";
    }

    /**
     * 查询所有博客类别信息
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        PageInfo<BlogType> pageInfo = new PageInfo<>(blogTypeService.getAll());
        map.put(Constant.ROWS, pageInfo.getList());
        map.put(Constant.TOTAL, pageInfo.getTotal());
        return map;
    }

    @RequestMapping("add")
    @ResponseBody
    public boolean add(BlogType blogType) {
        return blogTypeService.add(blogType);
    }

    @RequestMapping("remove")
    @ResponseBody
    public Map<String, Object> remove(@RequestParam("ids[]") Integer[] ids) {
        Map<String, Object> map = new HashMap<>();
        boolean flag = true;
        for (Integer id : ids) {
            flag = blogTypeService.remove(id);
        }
        map.put(Constant.SUCCESS, flag);
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public boolean update(BlogType blogType) {
        return blogTypeService.update(blogType);
    }

}
