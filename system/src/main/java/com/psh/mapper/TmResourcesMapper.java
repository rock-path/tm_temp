package com.psh.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psh.entity.TmResources;
import com.psh.entity.request.ReqTmResourcesQuery;
import com.psh.entity.response.ResTmResources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;



/**
* @Author psh
* @Date 2023-10-22
* @Time 15:20:51
*持久层
*/
@Mapper
public interface TmResourcesMapper extends BaseMapper<TmResources>  {

    /**
    * 分页查询
    */
    List<ResTmResources> listByPage(Page<ResTmResources> page, @Param("param") ReqTmResourcesQuery req);
}
