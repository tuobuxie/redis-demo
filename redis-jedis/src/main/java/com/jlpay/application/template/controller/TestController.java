package com.jlpay.application.template.controller;

import com.jlpay.application.template.controller.DTO.QueryRequest;
import com.jlpay.application.template.controller.DTO.QueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lishaofeng
 */
@Slf4j
@RestController
public class TestController {
    String value ="";

    public static final int M = 1024 * 1024;

    {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < M; i++) {
            stringBuffer.append("1");
        }
        value = stringBuffer.toString();

    }


    @Autowired
    RedisTemplate<String,String> redisTemplate;


    @GetMapping("/test/get/{key}")
    public String testGet( @PathVariable String key)  {
        //key:000000015796
        String o = redisTemplate.opsForValue().get(key);
        log.info(o);
        return o;
    }
    @GetMapping("/test/set/{key}/{value}")
    public String testSet(@PathVariable String key, @PathVariable String value)  {
        redisTemplate.opsForValue().set(key,value);
        return "00";

    }

    @GetMapping("/test/bigKey/{count}")
    public String bigKey( @PathVariable Integer count)  {
        for (int i = 0; i <count ; i++) {
            redisTemplate.opsForValue().set("bigKey:"+i,value);
        }
        return "00";

    }
}