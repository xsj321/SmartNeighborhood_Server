package com.hjj.server.login.controller;

import com.hjj.server.login.model.Account;
import com.hjj.server.login.service.LoginService;
import com.hjj.server.login.util.ErrorCode;
import com.hjj.server.login.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Api("login")
@RestController
@RequestMapping("loginController")
public class LoginController {

    @Autowired
    LoginService service;


    /**
     * 登录接口
     * @param account 账号对象
     * @return 登录信息
     */
    @ApiModelProperty(value = "新增目录",notes = "新增目录")
    @PostMapping("login")
    public ResponseVo login(@RequestBody Account account){
        ResponseVo res = new ResponseVo();
        try {
            res = service.login(account);
        }catch (Exception e){
            res.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            res.setSuccess(false);
            res.setMsg(ResponseVo.LOGIN_ERROR);
            //打印异常
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 注册接口
     * @param account 账号对象
     * @return 登录信息
     */
    @ApiModelProperty(value = "新增目录",notes = "新增目录")
    @PostMapping("register")
    public ResponseVo register(@RequestBody Account account){
        ResponseVo res = new ResponseVo();
        try {
            res = service.register(account);
        }catch (Exception e){
            res.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            res.setSuccess(false);
            res.setMsg(ResponseVo.REG_ERROR);
            //打印异常
            e.printStackTrace();
        }
        return res;
    }
}
