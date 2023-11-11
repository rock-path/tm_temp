package com.psh.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psh.domain.BaseResultModel;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.psh.entity.TmResources;
import com.psh.entity.request.ReqTmResourcesAdd;
import com.psh.entity.request.ReqTmResourcesQuery;
import com.psh.entity.request.ReqTmResourcesUpdate;
import com.psh.entity.response.ResTmResources;

/**
* @Author psh
* @Date 2023-10-22
* @Time 15:20:51
*服务层
*/
public interface TmResourcesService extends IService<TmResources>  {

    /**
    * 根据主键查询
    */
    BaseResultModel getOneById(Long id);
    
    /**
    * 新增
    */
    BaseResultModel insert(ReqTmResourcesAdd req);
    
    /**
    * 修改
    */
    BaseResultModel update(Long id, ReqTmResourcesUpdate req);
    
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
    BaseResultModel<IPage<ResTmResources>> page(Page<ResTmResources> page, ReqTmResourcesQuery req);
    
}
