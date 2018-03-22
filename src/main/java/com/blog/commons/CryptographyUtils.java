package com.blog.commons;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Description:密码加密工具类
 * @Author: liyong
 * @CreateDate: 2018/2/23 16:01
 * @Version: 1.0
 */
public abstract class CryptographyUtils {
    public static String md5(String str,String slat){
        return new Md5Hash(str,slat).toString();
    }

    public static void main(String[] args) {

        System.out.println(md5("123456","liyong"));
    }
}
