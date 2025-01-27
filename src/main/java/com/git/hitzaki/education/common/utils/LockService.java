package com.git.hitzaki.education.common.utils;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockService {
    @Autowired
    RedissonClient redissonClient;

}
