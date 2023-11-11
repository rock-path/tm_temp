package com.psh.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    private Long id;



    /**
     * 创建时间
     */

    private Date ctime;

    /**
     * 更新时间
     */

    private Date mtime;



    /**
     * 删除标记
     */

    private String deleted;


    /**
     * 创建人
     */

    private String cname;

    /**
     * 更新人
     */

    private String chname;
}
