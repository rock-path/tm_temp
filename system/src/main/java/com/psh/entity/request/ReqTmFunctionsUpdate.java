package com.psh.entity.request;




import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
            import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * 更新实体类
 *
 * @author psh
 * @since 2023-10-22 15:21:01
 */
@Data
@ApiModel(value = "TmFunctions更新对象", description = "更新实体对象")
public class ReqTmFunctionsUpdate implements Serializable{
    
        /**
    * 创建人
    */    
    @ApiModelProperty(value="创建人",name="cname")
    private String cname;
                         
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
