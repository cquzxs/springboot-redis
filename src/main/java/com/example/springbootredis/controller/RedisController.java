package com.example.springbootredis.controller;

import com.example.springbootredis.service.IRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    private IRedisService redisService;

    @GetMapping("set")
    public Object set(){
        redisService.set();
        return null;
    }

    @GetMapping("get")
    public Object get(){
        redisService.get();
        return null;
    }
}
