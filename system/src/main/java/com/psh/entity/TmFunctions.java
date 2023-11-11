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
 * 实体类
 *
 * @author psh
 * @since 2023-10-22 15:21:01
 */
@Data
@ApiModel(value = "TmFunctions对象", description = "实体对象")
public class TmFunctions {
    
        /**
    * 创建人
    */   
    @ApiModelProperty(value="创建人",name="cname")
                        private String cname;
                    
        /**
    * 逻辑删除
    */   
    @ApiModelProperty(value="逻辑删除",name="deleted")
            @TableLogic
    @TableField(value = "DELETED",fill = FieldFill.INSERT,jdbcType = JdbcType.VARCHAR)
            private String deleted;
        
        /**
    * 权限id
    */   
    @ApiModelProperty(value="权限id",name="functionId")
                        private String functionId;
        
        /**
    * 权限名
    */   
    @ApiModelProperty(value="权限名",name="functionName")
                        private String functionName;
        
        /**
    * 权限类型
    */   
    @ApiModelProperty(value="权限类型",name="functionType")
                        private String functionType;
        
        /**
    * 父权限id
    */   
    @ApiModelProperty(value="父权限id",name="parentId")
                        private String parentId;
        
        /**
    * 描述
    */   
    @ApiModelProperty(value="描述",name="described")
                        private String described;
    
}

