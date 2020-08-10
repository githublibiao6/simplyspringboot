package com.apps.omnipotent.business.entity;

import com.apps.omnipotent.system.core.Table;
import com.apps.omnipotent.system.core.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 随笔
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("essay")
public class Essay {

    private String id;
    /**
     * 文本
     */
    private String article;
    /**
     * 标题
     */
    private String title;
    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * 创建者
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
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
