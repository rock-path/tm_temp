package com.psh.controller;


import com.psh.entity.TmRole;
import com.psh.entity.request.ReqTmRoleAdd;
import com.psh.entity.request.ReqTmRoleQuery;
import com.psh.entity.request.ReqTmRoleUpdate;
import com.psh.entity.response.ResTmRole;
import com.psh.service.TmRoleService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.psh.domain.BaseResultModel;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;

/**
* @Author psh
* @Date 2023-10-22
* @Time 15:20:36
*控制层
*/
@RestController
@RequestMapping("/tmRole")
@Api(value="接口管理,，维护人:psh",tags ={"角色接口管理"})
public class TmRoleController {
    
    @Autowired
    private TmRoleService tmRoleService;

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return BaseResultModel对象
     */
    @ApiOperation(value="根据主键获取信息")
    @ApiImplicitParam(name="id",value="主键",dataType="Long", paramType = "query")
    @GetMapping("/getById/{id}")
    public BaseResultModel getById(@PathVariable("id") Long id) {
        return tmRoleService.getOneById(id);
    }
    
    /**
     * 新增
     *
     * @param req 实体类
     * @return BaseResultModel对象
     */
    @PostMapping(value = "/add")
    @ApiOperation(value="新增")
    public BaseResultModel insert(@RequestBody ReqTmRoleAdd req) {
        return tmRoleService.insert(req);
    }
    
    /**
     * 修改
     *
     * @param req 实体类
     * @param id 主键
     * @return BaseResultModel对象
     */
    @ApiOperation(value="修改")
    @ApiImplicitParam(name="id",value="主键",dataType="Long", paramType = "query")
    @PutMapping(value = "/update/{id}")
    public BaseResultModel update(@PathVariable("id") Long id,@RequestBody ReqTmRoleUpdate req) {
        return tmRoleService.update(id, req);
    }
    
    /**
     * 分页查询
     *
     * @param req 实体类
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "分页查询目录管理")
    @ApiImplicitParams({
        @ApiImplicitParam(name="pageNum",value="页码",dataType="Integer", paramType = "query"),
        @ApiImplicitParam(name="pageSize",value="条数",dataType="Integer", paramType = "query")
    })
    @GetMapping("/list/{pageNum}/{pageSize}")
    public BaseResultModel<IPage<ResTmRole>> list(ReqTmRoleQuery req, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        Page<ResTmRole> page = new Page<>(pageNum,pageSize);
        return tmRoleService.page(page,req);
    }

    /**
     * 单个删除
     *
     * @param id 主键
     * @return BaseResultModel对象
     */
    @ApiOperation(value="单个删除")
    @DeleteMapping("/delete/{id}")
    public BaseResultModel deleteOne(@PathVariable Long id){
        return tmRoleService.deleteOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids 主键列表
     * @return BaseResultModel对象
     */
     @ApiOperation(value="批量删除")
    @DeleteMapping("/delete")
    public BaseResultModel deleteBatch(@RequestBody List<Long> ids){
        return tmRoleService.deleteBatch(ids);
    }
    
    /**
     * 查询全部接口
     *
     * @return BaseResultModel对象
     */
    @ApiOperation(value="查询全部接口")
    @GetMapping("/getAll")
    public BaseResultModel<List<TmRole>> getAll() {
        QueryWrapper<TmRole> query = new QueryWrapper<>();
        query.eq("deleted", "0");
        return BaseResultModel.success(tmRoleService.list(query));
    }

}
