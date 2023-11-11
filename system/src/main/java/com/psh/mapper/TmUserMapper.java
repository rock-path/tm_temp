package com.psh.mapper;

import com.psh.entity.TmUser;
import com.psh.entity.request.ReqTmUserQuery;
import com.psh.entity.response.ResTmUser;
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
* @Date 2023-10-22
* @Time 15:13:40
*持久层
*/
@Mapper
public interface TmUserMapper extends BaseMapper<TmUser>  {

    /**
    * 分页查询
    */
    List<ResTmUser> listByPage(Page<ResTmUser> page, @Param("param") ReqTmUserQuery req);

    ResTmUser selectByUser(TmUser tmUser);
}
