package com.apps.omnipotent.manager.bean;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.core.TableField;
import lombok.Data;

import java.util.Date;

/**
 * 字典对象 Entity
 * @author lb
 *
 */
public class DictionaryTeams extends BaseModel<DictionaryTeams> {

    /**
     * 主键
     */
    private String id;
    /**
     * 字典对象
     */
    private String dicId;
    /**
     *  字典值
     */
    private String dicValue;
    /**
     *  字典项
     */
    private String dicText;
    /**
     *  说明
     */
    private String comments;
    /**
     *  排序
     */
    private String sort;
    /**
     * 创建者
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改者
     */
    @TableField("modify_user")
    private String modifyUser;
    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 生效标志
     */
    @TableField("effective_flag")
    private String effectiveFlag;
    /**
     * 删除标志
     */
    @TableField("delete_flag")
    private String deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDicId() {
        return dicId;
    }

    public void setDicId(String dicId) {
        this.dicId = dicId;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getDicText() {
        return dicText;
    }

    public void setDicText(String dicText) {
        this.dicText = dicText;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getEffectiveFlag() {
        return effectiveFlag;
    }

    public void setEffectiveFlag(String effectiveFlag) {
        this.effectiveFlag = effectiveFlag;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
