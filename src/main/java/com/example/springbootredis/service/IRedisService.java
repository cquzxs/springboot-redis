package com.example.springbootredis.service;

import com.example.springbootredis.model.User;

import java.util.List;

public interface IRedisService {
    void set();
    void get();

    String cacheString();
    User cacheObject();
    List<User> cacheList();
    Integer cacheInteger();
    Long cacheLong();
}
