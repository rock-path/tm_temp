package com.psh.login.controller;

import com.psh.domain.BaseResultModel;
import com.psh.entity.TmUser;
import com.psh.entity.response.ResTmUser;
import com.psh.service.TmUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "登录", tags = {"登录接口"})
public class LoginController {



    @Autowired
    private TmUserService tmUserService;


    /**
     * 查询用户的信息
     *
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public BaseResultModel<ResTmUser> selectByUser(@RequestBody TmUser tmUser, HttpServletRequest request, HttpServletResponse response) {
        return tmUserService.selectByUser(tmUser, request, response);
    }
}
