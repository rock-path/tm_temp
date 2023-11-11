package com.psh.entity.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
                                                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * 查询实体类
 *
 * @author psh
 * @since 2023-10-22 15:13:42
 */
@Data
@ApiModel(value = "TmUser查询对象", description = "查询实体对象")
public class ReqTmUserQuery implements Serializable{
    
        /**
    * 账号
    */    
    @ApiModelProperty(value="账号",name="account")
    private String account;
         
        /**
    * 用户名
    */    
    @ApiModelProperty(value="用户名",name="username")
    private String username;
         
        /**
    * 密码
    */    
    @ApiModelProperty(value="密码",name="password")
    private String password;
         
        /**
    * 性别
    */    
    @ApiModelProperty(value="性别",name="sex")
    private String sex;
         
        /**
    * 年龄
    */    
    @ApiModelProperty(value="年龄",name="age")
    private String age;
         
        /**
    * 电话号码
    */    
    @ApiModelProperty(value="电话号码",name="phoneNumber")
    private String phoneNumber;
         
        /**
    * 部门编号
    */    
    @ApiModelProperty(value="部门编号",name="departmentNo")
    private String departmentNo;
         
        /**
    * 职位
    */    
    @ApiModelProperty(value="职位",name="position")
    private String position;
         
        /**
    * 描述
    */    
    @ApiModelProperty(value="描述",name="described")
    private String described;
         
        /**
    * 创建人
    */    
    @ApiModelProperty(value="创建人",name="cname")
    private String cname;
                     
}
