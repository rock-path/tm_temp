package com.psh.entity.request;




import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
            import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * 商品表更新实体类
 *
 * @author psh
 * @since 2023-09-22 21:34:13
 */
@Data
@ApiModel(value = "TmCommodity更新对象", description = "商品表更新实体对象")
public class ReqTmCommodityUpdate implements Serializable{
    
        /**
    * 创建人
    */    
    @ApiModelProperty(value="创建人",name="cname")
    private String cname;
                         
        /**
    * 商品名称
    */    
    @ApiModelProperty(value="商品名称",name="commName")
    private String commName;
         
        /**
    * 商品价格
    */    
    @ApiModelProperty(value="商品价格",name="commPrice")
    private String commPrice;
         
        /**
    * 商品简介
    */    
    @ApiModelProperty(value="商品简介",name="commBrief")
    private String commBrief;
         
        /**
    * 商品描述
    */    
    @ApiModelProperty(value="商品描述",name="commDescribed")
    private String commDescribed;
         
        /**
    * 商品地址
    */    
    @ApiModelProperty(value="商品地址",name="commUrl")
    private String commUrl;
     
}
