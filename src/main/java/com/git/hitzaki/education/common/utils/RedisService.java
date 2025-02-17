package com.git.hitzaki.education.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // ============================== Key Commands ==============================

    public Boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean expireKey(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public Long getKeyExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    // ============================== String Commands ============================

    public void setString(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setStringWithExpire(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public Object getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Long incrementString(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    // ============================== Hash Commands ==============================

    public void setHashField(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public Object getHashField(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    public Map<Object, Object> getAllHashFields(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public void deleteHashFields(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    // ============================== List Commands ==============================

    public Long addToListLeft(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    public Long addToListRight(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    public List<Object> getListRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    // ============================== Set Commands ===============================

    public Long addToSet(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    public Set<Object> getSetMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    public Boolean isSetMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    // ============================== ZSet Commands ==============================

    public Boolean addToSortedSet(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public Set<Object> getSortedSetRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    // ============================== Pipeline ===================================

    public List<Object> executePipeline(RedisCallback<?> action) {
        return redisTemplate.executePipelined(action);
    }
}
