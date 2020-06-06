package com.hjj.server.cover.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cover {
    @ApiModelProperty("井盖地址")
    private String place;
    @ApiModelProperty("井盖状态 正常：0, 异常：1, 待处理：2")
    private boolean waring_code;
    @ApiModelProperty("井盖是否故障")
    private boolean waring;
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("警告列表")
    private List<Cover> waring_list;
    @ApiModelProperty("详情列表")
    private List<Cover> detail;

    /**
     * 生成返回数据格式
     * @param cover 井盖对象
     * @return 返回的数据
     */
    public Map<String,Object> makeRes(Cover cover){
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("cover",new Object(){
            public List<Cover> waring_list = cover.getWaring_list();
            public List<Cover> detail = cover.getDetail();
        });
        return resMap;
    }
}
