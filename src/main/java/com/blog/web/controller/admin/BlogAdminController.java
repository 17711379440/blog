package com.blog.web.controller.admin;

import com.blog.entity.Blog;
import com.blog.entity.IndexInfo;
import com.blog.lucene.BlogIndex;
import com.blog.service.BlogService;
import com.blog.web.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:博客管理控制类
 * @Author: liyong
 * @CreateDate: 2018/3/3 17:43
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogIndex blogIndex;

    /**
     * 导航到写博客页面
     *
     * @return
     */
    @RequestMapping("writeBlog")
    public String writeBlog() {
        return "admin/writeBlog";
    }


    /**
     * 添加博客
     *
     * @param blog
     * @return
     */
    @PostMapping("writeBlog")
    @ResponseBody
    public boolean writeBlog(Blog blog) throws Exception {
        boolean flag = blogService.add(blog);
        if(flag){
            blogIndex.addIndex(blog);
        }
        return flag;
    }

    /**
     * 查询所有博客信息
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(String page, String rows, String title) {
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setPageIndex(Integer.valueOf(page));
        indexInfo.setPageSize(Integer.valueOf(rows));
        indexInfo.setTitle(title);
        Map<String, Object> map = new HashMap<>();
        PageInfo<Blog> pageInfo = blogService.list(indexInfo);
        map.put(Constant.ROWS, pageInfo.getList());
        map.put(Constant.TOTAL, pageInfo.getTotal());
        return map;
    }

    /**
     * 导航到博客管理页面
     *
     * @return
     */
    @GetMapping("blogManager")
    public String blogManager() {
        return "admin/blogManager";
    }

    /**
     * 导航到修改页面
     *
     * @return
     */
    @GetMapping("update")
    public String update(Integer id,Model model) {
        model.addAttribute(Constant.BLOG,blogService.getBlogById(id));
        return "admin/updateBlog";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public boolean update(Blog blog) throws Exception {
          boolean flag = blogService.update(blog);
          if(flag){
              blogIndex.updateIndex(blog);
              //将该博客对应的图片从服务器中删除
              blogService.removeFile(blog.getId());
          }
          return flag;
    }


    @RequestMapping("remove")
    @ResponseBody
    public Map<String, Boolean> remove(@RequestParam("ids[]") Integer[] ids) throws Exception {
        Map<String, Boolean> map = new HashMap<>();
        boolean flag = true;
        for (Integer id : ids) {
            flag = blogService.remove(id);
            if(flag){
                blogIndex.deleteIndex(id);
                //将该博客对应的图片从服务器中删除
                blogService.removeFile(id);
            }
        }
        map.put(Constant.SUCCESS, flag);
        return map;
    }
}
