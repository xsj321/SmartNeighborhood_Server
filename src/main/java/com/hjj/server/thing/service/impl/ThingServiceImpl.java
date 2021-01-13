package com.hjj.server.thing.service.impl;

import com.hjj.server.thing.model.Thing;
import com.hjj.server.thing.model.ThingComponentType;
import com.hjj.server.thing.service.ThingService;
import com.hjj.server.util.ResponseVo;
import com.hjj.server.util.redis.RedisPoolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class ThingServiceImpl implements ThingService {
    @Autowired
    RedisPoolFactory redisPool;

    @Override
    public ResponseVo saveThing(Thing thing) {
        JedisPool jedisPool = redisPool.JedisFactory();
        Jedis jedis = jedisPool.getResource();
        jedis.set("test","a");
        jedis.close();
        return null;
    }

    @Override
    public ResponseVo deleteThing(String id) {
        return null;
    }

    @Override
    public Thing createThing(String name, String info, ThingComponentType type) {
        return null;
    }

    @Override
    public Thing loadThing(String id) {
        return null;
    }
}
