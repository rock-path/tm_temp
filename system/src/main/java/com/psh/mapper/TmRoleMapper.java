package com.psh.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psh.entity.TmRole;
import com.psh.entity.request.ReqTmRoleQuery;
import com.psh.entity.response.ResTmRole;
import com.psh.entity.response.ResTmRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;


/**
 * @Author psh
 * @Date 2023-10-22
 * @Time 15:20:37
 * 持久层
 */
@Mapper
public interface TmRoleMapper extends BaseMapper<TmRole> {

    /**
     * 分页查询
     */
    List<ResTmRole> listByPage(Page<ResTmRole> page, @Param("param") ReqTmRoleQuery req);

    @Select("select role_name from tm_user_role  where ACCOUNT = #{account} ")
    List<String> selectRole(@Param("account") String account);

    List<ResTmRoleVO> selectByRole(@Param("param")List<String> li);
}
