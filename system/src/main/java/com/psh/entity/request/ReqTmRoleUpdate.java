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
 * @since 2023-10-22 15:20:37
 */
@Data
@ApiModel(value = "TmRole更新对象", description = "更新实体对象")
public class ReqTmRoleUpdate implements Serializable{
    
        /**
    * 创建人
    */    
    @ApiModelProperty(value="创建人",name="cname")
    private String cname;
                         
        /**
    * 角色名
    */    
    @ApiModelProperty(value="角色名",name="roleName")
    private String roleName;
         
        /**
    * 描述
    */    
    @ApiModelProperty(value="描述",name="described")
    private String described;
     
}
