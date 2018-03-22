package com.blog.web.controller.admin;

import com.blog.commons.CryptographyUtils;
import com.blog.entity.BlogType;
import com.blog.entity.Blogger;
import com.blog.service.BlogTypeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Description:管理员折控制类
 * @Author: liyong
 * @CreateDate: 2018/2/1 14:51
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogTypeService blogTypeService;
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@Valid() Blogger blogger, Errors errors, Model model, HttpSession session, String rememberMe) {
        if (errors.hasErrors()) {
            return "admin/login";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), CryptographyUtils.md5(blogger.getPassWord(), blogger.getUserName()));
        Subject subject = SecurityUtils.getSubject();

        try {
//            if (subject.isRemembered()) {
//                return "redirect:home";
//            }
            subject.login(token);
            return "redirect:home";
        } catch (AuthenticationException e) {
            model.addAttribute("loginMsg", "用户名或密码错误");
            model.addAttribute("userName", blogger.getUserName());
            e.printStackTrace();
            login();
        }
        return null;
    }


    @RequestMapping("home")
    public String home(HttpSession session) {
        session.setAttribute("blogTypeList", blogTypeService.getAll());
        return "admin/home";
    }

}
