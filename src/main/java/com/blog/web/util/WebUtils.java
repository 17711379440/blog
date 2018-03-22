package com.blog.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/3/11 13:45
 * @Version: 1.0
 */
public abstract class WebUtils {
    public static void deleteFile(String fileName){

    }
    public static String getRealPath(HttpServletRequest request){
        return request.getRealPath("/userImages");
    }
}
