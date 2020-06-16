package com.apps.omnipotent.manager.bean;

import lombok.Data;

import java.util.Date;

/**
 * 部门 类
 * 
 * @author lb
 */
@Data
public class Dept {
    /**
     * 编号
     */
    private String code;
    /**
    * 部门名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *  创建人
     */
    private String createUser;
    /**
     * 修改人
     */
    private Date modifyUser;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 状态
     */
    private String state;
    /**
     * 说明
     */
    private String notes;

    @Override
    public String toString() {
        return "Dept [code=" + code + ", name=" + name + ", createUser=" + createUser + ", createTime=" + createTime
                + ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime + ", state=" + state + ", notes=" + notes
                + "]";
    }
    
}
