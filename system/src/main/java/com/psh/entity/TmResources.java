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
 * @since 2023-10-22 15:20:51
 */
@Data
@ApiModel(value = "TmResources对象", description = "实体对象")
public class TmResources {
    
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
    * 资源id
    */   
    @ApiModelProperty(value="资源id",name="resourcesId")
                        private String resourcesId;
        
        /**
    * 资源路径
    */   
    @ApiModelProperty(value="资源路径",name="resourcesUrl")
                        private String resourcesUrl;
        
        /**
    * 描述
    */   
    @ApiModelProperty(value="描述",name="described")
                        private String described;
    
}

