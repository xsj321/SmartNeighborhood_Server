package com.hjj.server.thing.model;

import com.hjj.server.thing.service.ThingFunc;
import com.hjj.server.thing.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;


public class Thing implements Serializable {

    @Autowired
    ThingService service;

    private String thingName;
    private String thingID;
    private String thingType;
    private String thingInfo;
    private Map<String, ThingComponent> thingComponents;

    public  Thing(String thingName, String thingID, String thingType, String thingInfo) {
        this.thingName = thingName;
        this.thingID = thingID;
        this.thingType = thingType;
        this.thingInfo = thingInfo;
    }

    public void registerThingComponent(String componentName,String info,ThingComponentType type)
    {
        ThingComponent theNewComponent = new ThingComponent(componentName,info);
        switch (type){
            case INT:
                theNewComponent.setCall(new ThingFunc() {
                    @Override
                    public ThingFuncRes control(ThingParam param) {
                        int value = param.getIntValue();
                        //todo do set
                        return null;
                    }

                    @Override
                    public ThingParam capture() {
                        //todo do get
                        return null;
                    }
                });

        }
        thingComponents.put(componentName,theNewComponent);
    }

}
