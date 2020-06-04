package com.hjj.server.login.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Account {
    @ApiModelProperty("个人id")
    private int id;
    @ApiModelProperty("账号")
    private String accountNumber;
    @ApiModelProperty("账户名称")
    private String accountUsername;
    @ApiModelProperty("账户密码")
    private String accountPassword;
}
