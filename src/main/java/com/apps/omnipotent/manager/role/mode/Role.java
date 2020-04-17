package com.apps.omnipotent.manager.role.mode;

import com.apps.omnipotent.system.global.entity.GlobalModel;
import lombok.Data;

/**
 * 菜单model
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Data
public class Role extends GlobalModel {
    private String id;
    private String code;
    private String name;
    private String notes;
}
