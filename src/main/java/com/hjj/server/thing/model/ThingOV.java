package com.hjj.server.thing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ThingOV implements Serializable {
    @ApiModelProperty("物名称")
    private String name;
    @ApiModelProperty("物ID唯一ID")
    private String id;
    @ApiModelProperty("物的描述")
    private String info;
    @ApiModelProperty("物的分类")
    private String type;
    @ApiModelProperty("组件集合")
    private List<ComponentItem> components;
}




