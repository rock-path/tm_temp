package com.psh.entity.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 查询返回实体类
 *
 * @author psh
 * @since 2023-10-22 15:21:01
 */
@Data
@ApiModel(value = "TmFunctions查询返回对象", description = "查询返回实体对象")
public class ResTmFunctions implements Serializable {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", name = "cname")
    private String cname;

    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id", name = "functionId")
    private String functionId;

    /**
     * 权限名
     */
    @ApiModelProperty(value = "权限名", name = "functionName")
    private String functionName;

    /**
     * 权限类型
     */
    @ApiModelProperty(value = "权限类型", name = "functionType")
    private String functionType;

    /**
     * 父权限id
     */
    @ApiModelProperty(value = "父权限id", name = "parentId")
    private String parentId;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", name = "described")
    private String described;


    /**
     * 路径
     */
    @ApiModelProperty(value = "描述", name = "described")
    private List<ResTmResources> resources;

}
