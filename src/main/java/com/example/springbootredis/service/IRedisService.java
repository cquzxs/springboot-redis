package com.example.springbootredis.service;

import com.example.springbootredis.model.User;

import java.util.List;
/**
 * @author: xueshan.zeng
 * @date: 2019/8/7
 */
public interface IRedisService {
    void set();
    void get();

    String cacheString();
    User cacheObject();
    List<User> cacheList();
    Integer cacheInteger();
    Long cacheLong();
}
