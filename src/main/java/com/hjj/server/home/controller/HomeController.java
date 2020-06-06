package com.hjj.server.home.controller;


import com.hjj.server.home.model.HomeVo;
import com.hjj.server.home.service.HomeService;
import com.hjj.server.util.ErrorCode;
import com.hjj.server.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api("home")
@RestController
@RequestMapping("homeController")
public class HomeController {
    @Autowired
    HomeService service;

    /**
     * 获取主页数据
     * @return 主页数据
     */
    @ApiModelProperty(value = "获取主页数据",notes = "获取主页数据")
    @GetMapping("home")
    public ResponseVo getHome(){
        ResponseVo res = ResponseVo.buildFailInstance();
        try {
            res = service.getHome();
        }catch (Exception e){
            res.setMsg("系统错误");
            e.printStackTrace();
        }
        return res;
    }
}
