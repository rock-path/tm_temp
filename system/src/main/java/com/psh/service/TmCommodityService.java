package com.psh.service;

import com.psh.domain.BaseResultModel;
import com.psh.entity.TmCommodity;
import com.psh.entity.request.ReqTmCommodityAdd;
import com.psh.entity.request.ReqTmCommodityUpdate;
import com.psh.entity.request.ReqTmCommodityQuery;
import com.psh.entity.response.ResTmCommodity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @Author psh
* @Date 2023-09-22
* @Time 21:34:13
*商品表服务层
*/
public interface TmCommodityService extends IService<TmCommodity>  {

    /**
    * 根据主键查询
    */
    BaseResultModel getOneById(Long id);
    
    /**
    * 新增
    */
    BaseResultModel insert(ReqTmCommodityAdd req);
    
    /**
    * 修改
    */
    BaseResultModel update(Long id, ReqTmCommodityUpdate req);
    
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
    BaseResultModel<IPage<ResTmCommodity>> page(Page<ResTmCommodity> page, ReqTmCommodityQuery req);
    
}
