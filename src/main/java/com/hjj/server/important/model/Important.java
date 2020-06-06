package com.hjj.server.important.model;

import com.hjj.server.cover.model.Cover;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Important {
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("地点名称")
    private String place;
    @ApiModelProperty("温度")
    private int temperature;
    @ApiModelProperty("湿度")
    private int humidity;
    @ApiModelProperty("空气状态")
    private boolean air;
    @ApiModelProperty("警告状态")
    private boolean waring;
    @ApiModelProperty("警告列表")
    private List<Important> waring_list;
    @ApiModelProperty("详情列表")
    private List<Important> detail;


    public Map<String,Object> makeRes(Important important){
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("important",new Object(){
            public List<Important> waring_list = important.getWaring_list();
            public List<Important> detail = important.getDetail();
        });
        return resMap;
    }
}
