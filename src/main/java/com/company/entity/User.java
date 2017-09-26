package com.company.entity;

/**
 * Created by Administrator on 2017/4/20.
 */
public class User {

    private Integer userId;
    private String username;    //淘宝会员名
    private String password;    //用户密码
    private String nickname;    //淘宝昵称
    private Boolean gender;     //性别

    @Override
    public String toString() {
        return "User{ " +
                "user_id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nick_name='" + nickname + '\'' +
                ", gender=" +gender +
                "}";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
