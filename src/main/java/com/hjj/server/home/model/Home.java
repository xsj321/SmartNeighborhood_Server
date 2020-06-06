package com.hjj.server.home.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Home implements Serializable {
    @ApiModelProperty("请求类型")
    private String respond_type;
    @ApiModelProperty("请求者")
    private String request_user;
    @ApiModelProperty("温度")
    private int temperature;
    @ApiModelProperty("湿度")
    private String humidity;
    @ApiModelProperty("PM2.5")
    private int PM;
    @ApiModelProperty("井盖是否警告")
    private boolean cover;
    @ApiModelProperty("重要场所是否警告")
    private boolean important;
    @ApiModelProperty("地点")
    private String place;
    @ApiModelProperty("地点id")
    private int LocationID;


    public Map<String,Object> makeRes(Home home){
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("info",new Object(){
            public String respond_type = home.getRespond_type();
            public String request_user = home.getRequest_user();
        });
        resMap.put("environment",new Object(){
            public int temperature = home.getTemperature();
            public String humidity = home.getHumidity();
            public int PM = home.PM;
        });
        resMap.put("waring",new Object(){
            public boolean cover = home.isCover();
            public boolean important = home.isImportant();
        });
        resMap.put("locaion",new Object(){
            public String place = home.getPlace();
            public int LocationID = home.getLocationID();
        });
        return resMap;
    }
}

