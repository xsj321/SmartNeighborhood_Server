package com.hjj.server.patrol.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Patrol {
    @ApiModelProperty("请求类型")
    private String respond_type;
    @ApiModelProperty("请求用户")
    private String request_user;
    @ApiModelProperty("工作人员名称")
    private String work_name;
    @ApiModelProperty("日期")
    private Date date;
    @ApiModelProperty("日期字符")
    private String dateString;
    @ApiModelProperty("路径")
    private String track;
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("工人id")
    private int worker_id;
    @ApiModelProperty("详情列表")
    private List<Patrol> detailList;


    public Map<String,Object> makeRes(Patrol patrol){
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("detail",new Object(){
            public List<Patrol> detail = patrol.getDetailList();
        });
        return resMap;
    }



}
