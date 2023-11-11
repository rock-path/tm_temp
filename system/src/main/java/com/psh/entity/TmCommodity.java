package com.psh.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.apache.ibatis.type.JdbcType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 商品表实体类
 *
 * @author psh
 * @since 2023-09-22 21:34:13
 */
@Data
@ApiModel(value = "TmCommodity对象", description = "商品表实体对象")
public class TmCommodity extends BaseEntity{

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", name = "cname")
    private String cname;

    /**
     * 逻辑删除
     */
    @ApiModelProperty(value = "逻辑删除", name = "deleted")
    @TableLogic
    @TableField(value = "DELETED", fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String deleted;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", name = "commName")
    private String commName;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", name = "commPrice")
    private String commPrice;

    /**
     * 商品简介
     */
    @ApiModelProperty(value = "商品简介", name = "commBrief")
    private String commBrief;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述", name = "commDescribed")
    private String commDescribed;

    /**
     * 商品地址
     */
    @ApiModelProperty(value = "商品地址", name = "commUrl")
    private String commUrl;

}

