package com.psh.login.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", name = "account")
    private String account;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username")
    private String sessionId;

}
