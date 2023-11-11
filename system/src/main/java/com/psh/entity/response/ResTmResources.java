package com.psh.entity.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 查询返回实体类
 *
 * @author psh
 * @since 2023-10-22 15:20:51
 */
@Data
@ApiModel(value = "TmResources查询返回对象", description = "查询返回实体对象")
public class ResTmResources implements Serializable {

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
     * 资源id
     */
    @ApiModelProperty(value = "资源id", name = "resourcesId")
    private String resourcesId;

    /**
     * 资源路径
     */
    @ApiModelProperty(value = "资源路径", name = "resourcesUrl")
    private String resourcesUrl;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", name = "described")
    private String described;




}
