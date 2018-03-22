package com.blog.web.util;

import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:图片工具类
 * @Author: liyong
 * @CreateDate: 2018/3/6 11:47
 * @Version: 1.0
 */
public abstract class ImgUtil {
    /**
     * 获取html中的图片；路径
     * @param htmlCode html代码
     * @return 图片路径集合
     */
    public static List<String> getImgUrl(String htmlCode){
        List<String> imageSrcList = new ArrayList<>();
//        Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);
        Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(htmlCode);
        String quote = null;
        String src = null;
        while (m.find()) {
            quote = m.group(1);
            src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);
            imageSrcList.add(src);
        }
        return imageSrcList;
    }

    /**
     * 获取项目的相对路径的绝对路径
     * @return
     */
    public static String getRealPath(){
       return ClassUtils.getDefaultClassLoader().getResource("static").getPath();
    }

    /**
     * 获得文件 路径
     * @return
     */

    public static String getFilePath(String path){
        return path.substring(path.indexOf("u"));
    }
}
