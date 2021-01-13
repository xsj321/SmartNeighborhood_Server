package com.hjj.server.thing.service.impl;

import com.hjj.server.thing.model.ComponentItem;
import com.hjj.server.thing.model.Thing;
import com.hjj.server.thing.model.ThingOV;
import com.hjj.server.thing.model.ThingParam;
import com.hjj.server.thing.service.ThingService;
import com.hjj.server.util.ResponseVo;
import com.hjj.server.util.redis.RedisPoolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.swing.*;
import java.util.List;

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
    public ResponseVo createThing( ThingOV thingOV) {

        Thing thing = new Thing(thingOV.getName(), thingOV.getId(), thingOV.getType(), thingOV.getInfo());
        List<ComponentItem> componentList = thingOV.getComponents();
        for (ComponentItem item :
                componentList) {
            thing.registerThingComponent(item.getName(), item.getInfo(), item.getType());
        }
        saveThing(thing);
        return ResponseVo.buildSuccessInstance();
    }

    @Override
    public Thing loadThing(String id) {
        return null;
    }
}
