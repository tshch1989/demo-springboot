package com.example.demospringboot.linebusiness.infrastructure.cache;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCache extends StringRedisTemplate {
    public RedisCache(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }
}
