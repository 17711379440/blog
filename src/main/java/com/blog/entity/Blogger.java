package com.blog.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @Description: 博主实体
 * @Author: liyong
 * @CreateDate: 2018/1/19 11:16
 * @Version: 1.0
 */
public class Blogger implements Serializable {
    //编号
    private Integer id;
    //用户名
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message ="密码不能为空")
    //密码
    private String passWord;
    //个人简介
    private String profile;
    //昵称
    private String nickName;
    //个性签名
    private String sign;
    //头像
    private String imageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Blogger{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", passWord='").append(passWord).append('\'');
        sb.append(", profile='").append(profile).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", sign='").append(sign).append('\'');
        sb.append(", imageName='").append(imageName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
