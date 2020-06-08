package com.hjj.server.patrol.controller;

import com.hjj.server.important.model.Important;
import com.hjj.server.patrol.model.Patrol;
import com.hjj.server.patrol.service.PatrolService;
import com.hjj.server.util.ErrorCode;
import com.hjj.server.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("patrol")
@RestController
@RequestMapping("patrolController")
public class PatrolController {

    @Autowired
    PatrolService service;


    @ApiModelProperty(value = "查询重要地点列表",notes = "查询重要地点列表")
    @PostMapping("getImportant")
    public ResponseVo getImportant(@RequestBody Patrol patrol){
        ResponseVo res = new ResponseVo();
        try {
            res = service.getPatrol(patrol);
        }catch (Exception e){
            res.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            res.setSuccess(false);
            res.setMsg(ResponseVo.LOGIN_ERROR);
            //打印异常
            e.printStackTrace();
        }
        return res;
    }
}
