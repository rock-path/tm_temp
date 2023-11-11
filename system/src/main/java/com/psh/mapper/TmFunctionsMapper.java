package com.psh.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psh.entity.TmFunctions;
import com.psh.entity.request.ReqTmFunctionsQuery;
import com.psh.entity.response.ResTmFunctions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import javax.validation.constraints.*;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


/**
* @Author psh
* @Date 2023-10-22
* @Time 15:21:01
*持久层
*/
@Mapper
public interface TmFunctionsMapper extends BaseMapper<TmFunctions>  {

    /**
    * 分页查询
    */
    List<ResTmFunctions> listByPage(Page<ResTmFunctions> page, @Param("param") ReqTmFunctionsQuery req);
}
