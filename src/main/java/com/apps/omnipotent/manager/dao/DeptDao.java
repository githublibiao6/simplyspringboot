package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Dept;
import com.apps.omnipotent.system.pagehelper.entity.QueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 部门 dao
 * @author lb
 *
 */
public interface DeptDao {

    /**
     * 获取所有的部门信息
     * @param queryCondition
     * @return
     */
    List<Dept> listDept(@Param("queryCondition") QueryCondition queryCondition);

    /**
     * 根据id获取部门详细信息
     * @param id
     * @return
     */
    Dept getDeptById(@Param("id") String id);
}
