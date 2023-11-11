package com.psh.mapper;

import com.psh.entity.TmCommodity;
import com.psh.entity.request.ReqTmCommodityQuery;
import com.psh.entity.response.ResTmCommodity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import javax.validation.constraints.*;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


/**
* @Author psh
* @Date 2023-09-22
* @Time 21:34:13
*商品表持久层
*/
@Mapper
public interface TmCommodityMapper extends BaseMapper<TmCommodity>  {

    /**
    * 分页查询
    */
    List<ResTmCommodity> listByPage(Page<ResTmCommodity> page, @Param("param") ReqTmCommodityQuery req);
}
