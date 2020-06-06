package com.hjj.server.important.controller;


import com.hjj.server.important.model.Important;
import com.hjj.server.important.service.ImportantService;
import com.hjj.server.login.model.Account;
import com.hjj.server.util.ErrorCode;
import com.hjj.server.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("important")
@RestController
@RequestMapping("importantController")
public class ImportantController {

    @Autowired
    ImportantService service;

    /**
     * 查询重要地点列表
     * @param important 查询条件
     * @return 重要地点列表
     */
    @ApiModelProperty(value = "查询重要地点列表",notes = "查询重要地点列表")
    @PostMapping("getImportant")
    public ResponseVo getImportant(@RequestBody Important important){
        ResponseVo res = new ResponseVo();
        try {
            res = service.getImportant(important);
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
