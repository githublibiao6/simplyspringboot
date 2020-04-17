package com.apps.omnipotent.manager.menu.mode;


import com.apps.omnipotent.system.global.entity.GlobalModel;

/**
 * 菜单model
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
public class Menu extends GlobalModel {
    private String menuId; //
    private String icon; // 图标
    private String menuText; // 菜单名称
    private String url; // 地址
    private String parent; // 父级菜单
    private String level; // 级别
    private String notes;// 说明
    private String menuType;//  菜单类型

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;//  菜单类型

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "menuId='" + menuId + '\'' +
                ", iconCls='" + icon + '\'' +
                ", menuText='" + menuText + '\'' +
                ", url='" + url + '\'' +
                ", parent='" + parent + '\'' +
                ", level='" + level + '\'' +
                ", notes='" + notes + '\'' +
                ", menuType='" + menuType + '\'' +
                '}';
    }
}
