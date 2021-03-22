ALTER TABLE be_dictionary
    ADD COLUMN `sys001`  datetime NULL COMMENT '新增时间' ,
    ADD COLUMN `sys002`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    ADD COLUMN `sys003`  varchar(50) NULL COMMENT '创建人' ,
    ADD COLUMN `sys004`  varchar(50) NULL COMMENT '修改人' ,
    ADD COLUMN `sys005`  varchar(1) NULL COMMENT '删除标记（1有效0删除）' ,
    ADD COLUMN `sys006`  varchar(2) NULL DEFAULT '00' COMMENT '状态位' ,
    ADD COLUMN `sys007`  int NULL DEFAULT 0 COMMENT '更新次数' ;


