package com.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author joncjing
 * @description
 * @date 2018/09/26-17/26
 **/
public abstract class BaseRedisDao<K,V> {

    @Autowired
    protected RedisTemplate<K,V> redisTemplate;

    public void setRedisTemplate(RedisTemplate<K,V> redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    protected RedisSerializer<String> getRedisSerializer(){
        return redisTemplate.getStringSerializer();
    }
}
