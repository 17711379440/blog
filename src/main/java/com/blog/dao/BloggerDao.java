package com.blog.dao;

import com.blog.entity.Blogger;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:52
 * @Version: 1.0
 */
public interface BloggerDao {
    /**
     * 根据用户名查询博主
     * @return 博主对象
     */
    Blogger get(String username);

    /**
     * 修改博主信息
     * @param blogger
     * @return
     */
    Integer update(Blogger blogger);
}
