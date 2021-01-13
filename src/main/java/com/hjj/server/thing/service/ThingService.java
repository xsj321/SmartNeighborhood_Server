package com.hjj.server.thing.service;

import com.hjj.server.thing.model.Thing;
import com.hjj.server.thing.model.ThingComponentType;
import com.hjj.server.util.ResponseVo;

public interface ThingService {
    ResponseVo saveThing(Thing thing);
    ResponseVo deleteThing(String id);
    Thing createThing(String name, String info, ThingComponentType type);
    Thing loadThing(String id);
}
