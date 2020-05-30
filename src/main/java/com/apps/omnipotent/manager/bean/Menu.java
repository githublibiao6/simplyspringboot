package com.apps.omnipotent.manager.bean;


import com.apps.omnipotent.system.global.entity.GlobalModel;
import lombok.Data;

import java.util.List;

/**
 * 菜单model
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Data
public class Menu extends GlobalModel {
    private String menuId;
    /**
     图标
     */
    private String icon;
    /**
     * 菜单名称
     */
    private String menuText;
    /**
     *  地址
     */
    private String url;
    /**
     * 父级菜单
     */
    private String parent;
    /**
     * 级别
     */
    private String level;
    /**
     * 说明
     */
    private String notes;
    /**
     * 菜单类型
     */
    private String menuType;
    /**
     * 是否有子节点
     */
    private boolean hasChildren;

    private List<Menu> children;

}
