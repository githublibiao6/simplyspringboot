package com.apps.omnipotent.manager.dictionary.bean;

import lombok.Data;

import java.util.Date;

/**
 * 字典对象 Entity
 * @author lb
 *
 */
@Data
public class DictionaryTeams {

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
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改者
     */
    private String modifyUser;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 生效标志
     */
    private String effectiveFlag;
    /**
     * 删除标志
     */
    private String deleteFlag;
    
}
