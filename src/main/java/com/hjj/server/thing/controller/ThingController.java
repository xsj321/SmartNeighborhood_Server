package com.hjj.server.thing.controller;

import com.hjj.server.cover.model.Cover;
import com.hjj.server.thing.model.Thing;
import com.hjj.server.thing.model.ThingParam;
import com.hjj.server.thing.service.ThingService;
import com.hjj.server.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("thing")
@RestController
@RequestMapping("thingController")
public class ThingController {
    @Autowired
    ThingService service;

    /**
     * 创建物设备模型
     * @return 创建结果
     */
    @ApiModelProperty(value = "创建物",notes = "创建物")
    @PostMapping("createThing")
    public ResponseVo createThing(){
        ResponseVo res = ResponseVo.buildFailInstance();
        try {
            Thing thing = new Thing("xsj321", "11", "Make", "mon");
            service.saveThing(thing);
        }catch (Exception e){
            e.printStackTrace();
            res.setMsg("系统错误");
        }
        return res;
    }
}
