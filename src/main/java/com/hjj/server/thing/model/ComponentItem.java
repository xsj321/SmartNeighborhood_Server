package com.hjj.server.thing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ComponentItem implements Serializable {
    @ApiModelProperty("组件名称")
    private String name;
    @ApiModelProperty("组件介绍")
    private String info;
    @ApiModelProperty("组件id")
    private String id;
    @ApiModelProperty("组件类型")
    private ThingComponentType type;
}
