package com.no1worker.common.bean;

import java.io.Serializable;

/**
 * 用户信息
 * Created by yuzhiyong on 2018/4/4.
 */
public class UserInfo implements Serializable {

    private long id;// 用户id

    private String username;// 用户名

    private String password;// 密码

    private String email;// 邮箱

    private String phone;// 手机号

    private String question;// 找回密码问题

    private String answer;// 找回密码答案

    private String createTime;// 创建时间

    private String updateTime;// 修改时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
