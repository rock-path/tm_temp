package com.psh.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psh.domain.BaseResultModel;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.psh.entity.TmFunctions;
import com.psh.entity.request.ReqTmFunctionsAdd;
import com.psh.entity.request.ReqTmFunctionsQuery;
import com.psh.entity.request.ReqTmFunctionsUpdate;
import com.psh.entity.response.ResTmFunctions;

/**
* @Author psh
* @Date 2023-10-22
* @Time 15:21:01
*服务层
*/
public interface TmFunctionsService extends IService<TmFunctions>  {

    /**
    * 根据主键查询
    */
    BaseResultModel getOneById(Long id);
    
    /**
    * 新增
    */
    BaseResultModel insert(ReqTmFunctionsAdd req);
    
    /**
    * 修改
    */
    BaseResultModel update(Long id, ReqTmFunctionsUpdate req);
    
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
    BaseResultModel<IPage<ResTmFunctions>> page(Page<ResTmFunctions> page, ReqTmFunctionsQuery req);
    
}
