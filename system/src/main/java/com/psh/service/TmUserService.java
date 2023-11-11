package com.psh.service;

import com.psh.entity.TmUser;
import com.psh.entity.request.ReqTmUserAdd;
import com.psh.entity.request.ReqTmUserUpdate;
import com.psh.entity.request.ReqTmUserQuery;
import com.psh.entity.response.ResTmUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psh.domain.BaseResultModel;
import java.util.List;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Author psh
* @Date 2023-10-22
* @Time 15:13:41
*服务层
*/
public interface TmUserService extends IService<TmUser>  {

    /**
    * 根据主键查询
    */
    BaseResultModel getOneById(Long id);
    
    /**
    * 新增
    */
    BaseResultModel insert(ReqTmUserAdd req);
    
    /**
    * 修改
    */
    BaseResultModel update(Long id, ReqTmUserUpdate req);
    
    /**
    * 单个删除
    */
    BaseResultModel deleteOne(Long id);
    
    /**
    * 批量删除
    */
    BaseResultModel deleteBatch(List<Long> ids);
    
    /**
    *分页查询
    */
    BaseResultModel<IPage<ResTmUser>> page(Page<ResTmUser> page, ReqTmUserQuery req);

    BaseResultModel<ResTmUser> selectByUser(TmUser tmUser, HttpServletRequest request, HttpServletResponse response);
}
