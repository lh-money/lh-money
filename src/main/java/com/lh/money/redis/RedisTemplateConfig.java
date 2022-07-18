package com.lh.money.redis;

import java.time.Month;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 */
@RestController
public class RedisTemplateConfig {

    @Autowired(required = false)
    StringRedisTemplate redisTemplate;

    @RequestMapping("/a")
    public void redisCache(){
        redisTemplate.opsForValue().set("lihao","money",10, TimeUnit.SECONDS);
        System.out.println("成功");
    }


    public static void main(String[] args) {
        RedisTemplateConfig redisTemplateConfig = new RedisTemplateConfig();
        redisTemplateConfig.redisCache();
    }
}
