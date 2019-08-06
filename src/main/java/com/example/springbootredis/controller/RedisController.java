package com.example.springbootredis.controller;

import com.example.springbootredis.model.User;
import com.example.springbootredis.service.IRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RedisController {
    @Resource
    private IRedisService redisService;

    @GetMapping("set")
    public Object set(){
        redisService.set();
        return "ok";
    }

    @GetMapping("get")
    public Object get(){
        redisService.get();
        return "ok";
    }

    @GetMapping("cache")
    public Object cache(){
        String token = redisService.cacheString();
        System.out.println("token:"+token);
        User user = redisService.cacheObject();
        System.out.println("userInfo:"+user);
        List<User> list = redisService.cacheList();
        System.out.println("userList:"+list);
        Integer i = redisService.cacheInteger();
        System.out.println("integer:"+i);
        //Long l = redisService.cacheLong(); //报类型转换的错
        //System.out.println("long:"+l);
        return "ok";
    }
}
