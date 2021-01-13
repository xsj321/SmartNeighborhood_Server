package com.hjj.server.thing.service;

import com.hjj.server.thing.model.ThingComponent;
import com.hjj.server.thing.model.ThingFuncRes;
import com.hjj.server.thing.model.ThingParam;

import java.math.BigDecimal;

public interface ThingFunc {
    ThingFuncRes control(ThingParam param);
    ThingParam capture();


}
