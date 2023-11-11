package com.psh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psh.domain.BaseResultModel;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.psh.entity.TmRole;
import com.psh.entity.request.ReqTmRoleAdd;
import com.psh.entity.request.ReqTmRoleQuery;
import com.psh.entity.request.ReqTmRoleUpdate;
import com.psh.entity.response.ResTmRole;
import com.psh.entity.response.ResTmRoleVO;

/**
* @Author psh
* @Date 2023-10-22
* @Time 15:20:37
*服务层
*/
public interface TmRoleService extends IService<TmRole>  {

    /**
    * 根据主键查询
    */
    BaseResultModel getOneById(Long id);
    
    /**
    * 新增
    */
    BaseResultModel insert(ReqTmRoleAdd req);
    
    /**
    * 修改
    */
    BaseResultModel update(Long id, ReqTmRoleUpdate req);
    
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
    BaseResultModel<IPage<ResTmRole>> page(Page<ResTmRole> page, ReqTmRoleQuery req);

    List<ResTmRoleVO> selectbyAccount(String account);
}
