package com.example.springbootredis.service.impl;

import com.example.springbootredis.model.User;
import com.example.springbootredis.service.IRedisService;
import com.example.springbootredis.util.RedisUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
@CacheConfig(cacheNames = "redis")
public class RedisServiceImpl implements IRedisService {

    @Resource
    private RedisUtil redisUtil;


    @Override
    public void set() {
        //字符串
        redisUtil.set("token","zxs",1800);
        //Hash
        Map<String,Object> map = new HashMap<>();
        map.put("username","张三");
        map.put("password","123");
        redisUtil.hSet("userInfo",map,1800);
        //Set
        Set<String> set = new HashSet<>();
        set.add("北京");
        set.add("上海");
        set.add("广州");
        for (String s:set) {
            redisUtil.sSetAndTime("area",1800, s);
        }
        //List
        List<User> list = new ArrayList<>();
        list.add(new User("张三","123"));
        list.add(new User("李四","123"));
        redisUtil.lSet("userList",list,1800);
        //zSet
        redisUtil.zSet("rank","张三",100);
        redisUtil.zSet("rank","李四",98);
        redisUtil.zSet("rank","王五",95);
        redisUtil.zSet("rank","赵六",95);
    }

    @Override
    public void get() {
        //字符串
        String token = redisUtil.get("token").toString();
        System.out.println("token:"+token);
        //Hash
        Map<String, Object> map = redisUtil.hGet("userInfo");
        System.out.println("userInfo:"+map);
        //Set
        Set<Object> set = redisUtil.sGet("area");
        System.out.println("area:"+set);
        //List
        List<Object> list = redisUtil.lGet("userList",0,-1);
        List<User> newList= (List<User>)list.get(0);
        System.out.println("userList:"+newList);
        //zSet
        Set<Object> zSet = redisUtil.zGet("rank",0,100);
        System.out.println("rank:"+zSet);
    }

    @Cacheable(key = "'token'")
    @Override
    public String cacheString() {
        return "zxs";
    }

    @Cacheable(key = "'userInfo'")
    @Override
    public User cacheObject() {
        return new User("张三","123");
    }

    @Cacheable(key = "'userList'")
    @Override
    public List<User> cacheList() {
        List<User> list = new ArrayList<>();
        list.add(new User("张三","123"));
        list.add(new User("李四","123"));
        return list;
    }

    @Cacheable(key = "'cacheInteger'")
    @Override
    public Integer cacheInteger() {
        return 1;
    }

    @Cacheable(key = "'cacheLong'")
    @Override
    public Long cacheLong() {
        return 1L;
    }

}
