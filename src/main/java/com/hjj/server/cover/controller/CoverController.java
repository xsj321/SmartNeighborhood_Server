package com.hjj.server.cover.controller;

import com.hjj.server.cover.model.Cover;
import com.hjj.server.cover.service.CoverService;
import com.hjj.server.home.service.HomeService;
import com.hjj.server.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("cover")
@RestController
@RequestMapping("coverController")
public class CoverController {
    @Autowired
    CoverService service;

    /**
     * 获取井盖信息
     * @param cover 传入的井盖对象
     * @return 井盖列表
     */
    @ApiModelProperty(value = "获取井盖信息",notes = "获取井盖信息")
    @PostMapping("cover")
    public ResponseVo getCover(@RequestBody Cover cover){
        ResponseVo res = ResponseVo.buildFailInstance();
        try {
            res = service.getCover(cover);
        }catch (Exception e){
            e.printStackTrace();
            res.setMsg("系统错误");
        }
        return res;
    }


    /**
     * 修复井盖接口
     * @param cover 传入的井盖对象
     * @return 修复结果
     */
    @ApiModelProperty(value = "修复井盖",notes = "修复井盖")
    @PostMapping("fixCover")
    public ResponseVo fixCover(@RequestBody Cover cover){
        ResponseVo res = ResponseVo.buildFailInstance();
        try {
            res = service.fixCover(cover);
        }catch (Exception e){
            e.printStackTrace();
            res.setMsg("系统错误");
        }
        return res;
    }
}
