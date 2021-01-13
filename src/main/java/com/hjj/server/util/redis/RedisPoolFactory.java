package com.hjj.server.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {
    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool JedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(Integer.parseInt(redisConfig.getPool().get("maxActive")));
        poolConfig.setMaxIdle(Integer.parseInt(redisConfig.getPool().get("maxIdle")));
        poolConfig.setMaxWaitMillis(Integer.parseInt(redisConfig.getPool().get("maxWait")) * 1000L);  //注意单位是ms，要转换单位
        poolConfig.setMinIdle(Integer.parseInt(redisConfig.getPool().get("minIdle")));
        return new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
                redisConfig.getTimeout() * 1000, redisConfig.getPassword(), 0);
    }
}
