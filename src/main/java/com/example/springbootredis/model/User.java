package com.example.springbootredis.model;

import java.io.Serializable;
/**
 * @author: xueshan.zeng
 * @date: 2019/8/7
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4639927280734526763L;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
