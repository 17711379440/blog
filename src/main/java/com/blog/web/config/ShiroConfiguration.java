package com.blog.web.config;

import com.blog.realm.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:shiro配置类
 * @Author: liyong
 * @CreateDate: 2018/2/23 16:46
 * @Version: 1.0
 */
@Configuration
public class ShiroConfiguration {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //登录请求的url
        bean.setLoginUrl("/admin/login");
        //登录成功跳转的链接
        bean.setSuccessUrl("/admin/home");
        //未授权的跳转的页面
//        bean.setUnauthorizedUrl("/");
        //配置访问权限
        Map<String,String> map = new LinkedHashMap<>();
        //不验证的请求
        map.put("/admin/login","anon");
        map.put("/admin/**","authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }

    @Bean("authRealm")
    public AuthRealm initAuthRealm(){
        return new AuthRealm();
    }
    /**
     * 将自定义的realm配置到安全管理器
     * @return
     */
    @Bean("securityManager")
    public SecurityManager  securityManager(@Qualifier("authRealm") AuthRealm authRealm){
       return new DefaultWebSecurityManager(authRealm);
    }
/*    public AuthRealm authRealm(){
        return new AuthRealm();
    }*/

}
