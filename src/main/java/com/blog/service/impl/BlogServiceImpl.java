package com.blog.service.impl;

import com.blog.dao.BlogDao;
import com.blog.entity.Blog;
import com.blog.entity.IndexInfo;
import com.blog.entity.Thumbnail;
import com.blog.service.AnswerService;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import com.blog.service.ThumbnailService;
import com.blog.web.util.ImgUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.util.List;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 13:57
 * @Version: 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private ThumbnailService thumbnailService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private CommentService commentService;
    //存储博客的缩略图
    private List<Thumbnail> list;

    /**
     * 查询所有博文
     *
     * @return 所有博文
     */
    @Override
    public PageInfo<Blog> list(IndexInfo indexInfo) {
        PageHelper.startPage(indexInfo.getPageIndex(), indexInfo.getPageSize());
        List<Blog> list = blogDao.list(indexInfo);
        return new PageInfo<>(list);
    }


    /**
     * 根据关键字搜索博文
     *
     * @param keyWord 关键字
     * @return
     */
    @Override
    public List<Blog> getBlogsByKeyWord(String keyWord) {
        return blogDao.getBlogsByKeyWord(keyWord);
    }

    /**
     * 查询日期
     *
     * @return
     */
    @Override
    public List<String> dateList() {
        return blogDao.dateList();
    }

    /**
     * 通过id查询博文
     *
     * @param id
     * @return
     */
    @Override
    public Blog getBlogById(Integer id) {
        return blogDao.getBlogById(id);
    }

    /**
     * 添加博文
     *
     * @param blog
     * @return 受影响的行数
     */
    @Override
    @Transactional
    public boolean add(Blog blog) {

        try {
            blogDao.add(blog);
            for (String str : ImgUtil.getImgUrl(blog.getContent())) {
                Thumbnail thumbnail = new Thumbnail();
                thumbnail.setImageSrc(str);
                thumbnail.setBlog(blog);
                thumbnailService.add(thumbnail);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除博文
     *
     * @param id 博文编号
     * @return true删除成功；false删除失败
     */
    @Override
    @Transactional
    public boolean remove(Integer id) {
         list = thumbnailService.getThumbnailList(id);
        try {
            thumbnailService.remove(id);
            answerService.remove(id);
            commentService.remove(id);
            blogDao.remove(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改博文
     *
     * @param blog
     * @return
     */
    @Override
    @Transactional
    public boolean update(Blog blog) {
        list = thumbnailService.getThumbnailList(blog.getId());
        try {
            thumbnailService.remove(blog.getId());
            for (String str : ImgUtil.getImgUrl(blog.getContent())) {
                Thumbnail thumbnail = new Thumbnail();
                thumbnail.setImageSrc(str);
                thumbnail.setBlog(blog);
                thumbnailService.add(thumbnail);
            }
            blogDao.update(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新游览书或者评论数
     *
     * @param flag
     * @param id
     */
    @Override
    public void updateNum(Boolean flag, Integer id) {
        blogDao.updateNum(flag, id);
    }

    /**
     * 删除对应博客Id的缩略图
     *
     * @param id
     */
    @Override
    public void removeFile(Integer id) {
        boolean flag = false;
        for (Thumbnail thumbnail : list){
            File file = new File(ImgUtil.getRealPath()+File.separator+ImgUtil.getFilePath(thumbnail.getImageSrc()));
            flag =  file.delete();
        }
    }
}
