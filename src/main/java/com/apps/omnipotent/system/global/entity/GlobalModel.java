package com.apps.omnipotent.system.global.entity;

import lombok.Data;

import java.util.Date;

/**
 * 基础model(默认参数)
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Data
public class GlobalModel extends Tmodel {
    /*
    * 创建人部门
     */
    private String createUser;
    private String createDept;
    /*
    创建时间
     */
    private Date createTime;
    /*
    修改人
     */
    private String modifyUser;
    /*
    修改人部门
     */
    private String modifyDept;
    /*
    修改时间
     */
    private Date modifyTime;
    /*
    有效标志
     */
    private String effectiveFlag;
    /*
    删除标记
     */
    private String deleteFlag;

}
