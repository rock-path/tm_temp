
CREATE TABLE `tm_user`
(
    `ID`            bigint       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `ACCOUNT`       varchar(64)  not NULL COMMENT '账号',
    `USERNAME`      varchar(64)  not NULL COMMENT '用户名',
    `password`      varchar(100) not NULL COMMENT '密码',
    `SEX`           varchar(2)        DEFAULT NULL COMMENT '性别',
    `AGE`           varchar(2)        DEFAULT NULL COMMENT '年龄',
    `PHONE_NUMBER`  varchar(32)  not NULL COMMENT '电话号码',
    `DEPARTMENT_NO` varchar(32)  not NULL COMMENT '部门编号',
    `POSITION`      varchar(32)       DEFAULT NULL COMMENT '职位',
    `DESCRIBED`     varchar(64)       DEFAULT NULL COMMENT '描述',
    `CNAME`         varchar(64)       DEFAULT NULL COMMENT '创建人',
    `CTIME`         timestamp    NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `CHNAME`        varchar(64)       DEFAULT NULL COMMENT '修改人',
    `MTIME`         datetime          DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `DELETED`       bit(1)            DEFAULT b'0' COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 11   DEFAULT CHARSET = utf8mb4;



CREATE TABLE `tm_role` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                           `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                           `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                           `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                           `role_name` varchar(64) DEFAULT NULL COMMENT '角色名',
                           `described` varchar(64) DEFAULT NULL COMMENT '描述',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `tm_user_role` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                                `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                                `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                                `role_name` varchar(64) DEFAULT NULL COMMENT '角色名',
                                `account` varchar(64) DEFAULT NULL COMMENT '账号',
                                `described` varchar(64) DEFAULT NULL COMMENT '描述',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `tm_role_function` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                    `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                                    `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                                    `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                    `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                                    `role_name` varchar(64) DEFAULT NULL COMMENT '角色名',
                                    `function_id` varchar(64) DEFAULT NULL COMMENT '权限id',
                                    `described` varchar(64) DEFAULT NULL COMMENT '描述',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `tm_functions` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                                `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                                `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                                `function_id` varchar(64) DEFAULT NULL COMMENT '权限id',
                                `function_name` varchar(64) DEFAULT NULL COMMENT '权限名',
                                `function_type` varchar(64) DEFAULT NULL COMMENT '权限类型',
                                `parent_id` varchar(64) DEFAULT NULL COMMENT '父权限id',
                                `described` varchar(64) DEFAULT NULL COMMENT '描述',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



CREATE TABLE `tm_function_resources` (
                                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                         `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                                         `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                                         `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                         `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                                         `resources_id` varchar(64) DEFAULT NULL COMMENT '资源id',
                                         `function_id` varchar(64) DEFAULT NULL COMMENT '权限id',
                                         `described` varchar(64) DEFAULT NULL COMMENT '描述',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `tm_resources` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                                `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                                `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                                `resources_id` varchar(64) DEFAULT NULL COMMENT '资源id',
                                `resources_url` varchar(64) DEFAULT NULL COMMENT '资源路径',
                                `described` varchar(64) DEFAULT NULL COMMENT '描述',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `tm_commodity` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                `cname` varchar(64) DEFAULT NULL COMMENT '创建人',
                                `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `chname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                                `mtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
                                `comm_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
                                `comm_price` varchar(64) DEFAULT NULL COMMENT '商品价格',
                                `comm_brief` varchar(128) DEFAULT NULL COMMENT '商品简介',
                                `comm_described` varchar(1024) DEFAULT NULL COMMENT '商品描述',
                                `comm_url` varchar(256) DEFAULT NULL COMMENT '商品地址',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8  COMMENT '商品表' ;




