package com.hjj.server.thing.service;

import com.hjj.server.thing.model.Thing;
import com.hjj.server.thing.model.ThingComponentType;
import com.hjj.server.thing.model.ThingOV;
import com.hjj.server.thing.model.ThingParam;
import com.hjj.server.util.ResponseVo;

public interface ThingService {
    ResponseVo saveThing(Thing thing);
    ResponseVo deleteThing(String id);
    ResponseVo createThing(ThingOV thingOV);
    Thing loadThing(String id);
}
