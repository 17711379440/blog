package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 17:30
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.blog.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
