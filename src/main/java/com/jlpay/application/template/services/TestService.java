package com.jlpay.application.template.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishaofeng
 */
@Slf4j
@Service
public class TestService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public String testGet(  String key)  {
        String o = redisTemplate.opsForValue().get(key);
        log.info(o);
        return o;
    }
    public void testSet( String key,  String value)  {
        redisTemplate.opsForValue().set(key,value);
    }

}