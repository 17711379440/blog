package com.example.blog;

import com.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/2/26 13:21
 * @Version: 1.0
 */
@Controller
public class Test {
        @Autowired
    private BloggerService bloggerService;

    public void test(){
        System.out.println(bloggerService.getBlogger("liyong"));
    }

    @org.junit.Test
    public  void getRealPath(){
//        String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
      int i =  "http://localhost/userImages/20180311/1520777257723057945.jpg".indexOf("u");
        String str = "http://localhost/userImages/20180311/1520777257723057945.jpg".substring(i);
        System.out.println(str);
    }
}
