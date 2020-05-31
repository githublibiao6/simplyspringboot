package com.apps.omnipotent.manager.bean;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.core.Table;
import lombok.Data;

import java.util.Date;

/**
 * 字典 Entity
 * @author cles
 *
 */
@Data
@Table("dictionary")
public class Dictionary extends BaseModel<Dictionary> {

    /**
     * 主键
     */
    private String id;
    /**
    * 编码
     */
    private String code;
    /**
     *  名称
     */
    private String name;
    /**
     *  说明
     */
    private String comments;
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
