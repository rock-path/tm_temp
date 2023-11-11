package com.psh.entity.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 查询返回实体类
 *
 * @author psh
 * @since 2023-10-22 15:20:37
 */
@Data
@ApiModel(value = "TmRole查询返回对象", description = "查询返回实体对象")
public class ResTmRoleVO implements Serializable {



    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名", name = "roleName")
    private String roleName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", name = "described")
    private String described;

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
    private String describedFun;


    /**
     * 资源路径
     */
    @ApiModelProperty(value = "资源路径", name = "resourcesUrl")
    private String resourcesUrl;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", name = "described")
    private String describedRes;



}
