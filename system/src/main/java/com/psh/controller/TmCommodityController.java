package com.psh.controller;

import com.psh.domain.BaseResultModel;
import com.psh.entity.TmCommodity;
import com.psh.entity.request.ReqTmCommodityAdd;
import com.psh.entity.request.ReqTmCommodityUpdate;
import com.psh.entity.request.ReqTmCommodityQuery;
import com.psh.entity.response.ResTmCommodity;
import com.psh.service.TmCommodityService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author psh
 * @Date 2023-09-22
 * @Time 21:34:13
 * 商品表控制层
 */
@RestController
@RequestMapping("/tmCommodity")
@Api(value = "商品表接口管理,，维护人:psh", tags = {"商品表接口管理"})
public class TmCommodityController {

    @Autowired
    private TmCommodityService tmCommodityService;

    /**
     * 根据主键查询
     *
     * @param id 商品表主键
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "根据主键获取商品表信息")
    @ApiImplicitParam(name = "id", value = "商品表主键", dataType = "Long", paramType = "query")
    @GetMapping("/getById/{id}")
    public BaseResultModel getById(@PathVariable("id") Long id) {
        return tmCommodityService.getOneById(id);
    }

    /**
     * 新增
     *
     * @param req 实体类
     * @return BaseResultModel对象
     */
    @PostMapping(value = "/add")
    @ApiOperation(value = "新增商品表")
    public BaseResultModel insert(@RequestBody ReqTmCommodityAdd req) {
        return tmCommodityService.insert(req);
    }


    @Value("${file.upload}")
    private String realPath;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    @ApiImplicitParam(name = "file", value = "单个文件", required = true, dataType = "__file")
    public String upload(@ApiParam(required = true) @RequestParam("file") MultipartFile file, HttpServletRequest req) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
//        String format = sdf.format(new Date());
        File folder = new File(realPath );
        String filePath = "";
        folder.mkdirs();
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() +
                oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            file.transferTo(new File(folder, newName));
            filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                    req.getServerPort() + "/api/uploadFile/"  + newName;
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败! ";
        }
        return filePath;
    }



    /**
     * 修改
     *
     * @param req 实体类
     * @param id  商品表主键
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "修改商品表")
    @ApiImplicitParam(name = "id", value = "商品表主键", dataType = "Long", paramType = "query")
    @PutMapping(value = "/update/{id}")
    public BaseResultModel update(@PathVariable("id") Long id, @RequestBody ReqTmCommodityUpdate req) {
        return tmCommodityService.update(id, req);
    }

    /**
     * 分页查询
     *
     * @param req 实体类
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "分页查询目录管理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "条数", dataType = "Integer", paramType = "query")
    })
    @GetMapping("/list")
    public BaseResultModel<IPage<ResTmCommodity>> list(ReqTmCommodityQuery req, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<ResTmCommodity> page = new Page<>(pageNum, pageSize);
        return tmCommodityService.page(page, req);
    }

    /**
     * 单个删除
     *
     * @param id 商品表主键
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "单个删除商品表")
    @DeleteMapping("/delete/{id}")
    public BaseResultModel deleteOne(@PathVariable Long id) {
        return tmCommodityService.deleteOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids 主键列表
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "批量删除商品表")
    @DeleteMapping("/delete")
    public BaseResultModel deleteBatch(@RequestBody List<Long> ids) {
        return tmCommodityService.deleteBatch(ids);
    }

    /**
     * 查询全部接口
     *
     * @return BaseResultModel对象
     */
    @ApiOperation(value = "查询全部接口")
    @GetMapping("/getAll")
    public BaseResultModel<List<TmCommodity>> getAll() {
        QueryWrapper<TmCommodity> query = new QueryWrapper<>();
        query.eq("deleted", "0");
        return BaseResultModel.success(tmCommodityService.list(query));
    }

}
