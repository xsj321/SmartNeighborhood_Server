package com.hjj.server.thing.model;

import lombok.Data;

@Data
public class ThingParam {
    private int intValue;
    private double doubleValue;
    private float floatValue;
    private boolean booleanValue;
    private Enum enumValue;
}
