package com.blog.entity;

/**
 * @Description:
 * @Author: liyong
 * @CreateDate: 2018/1/22 15:31
 * @Version: 1.0
 */
public class IndexInfo {
    //页码
    private Integer pageIndex = 1;
    //页大小
    private Integer pageSize = 10;
    //关键字
    private String keyWord;
    //日期类别
    private String createDateStr;
    //博文标题
    private String title;
    //博文类型
    private Integer typeId;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
