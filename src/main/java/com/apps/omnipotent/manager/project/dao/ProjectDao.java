package com.apps.omnipotent.manager.project.dao;

import com.apps.omnipotent.manager.project.bean.Project;
import com.apps.omnipotent.system.pagehelper.entity.QueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目 dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
public interface ProjectDao {

    /**
     * 根据条件获得Project
     * @param queryCondition
     * @return
     */
    List<Project> listProject(@Param("queryCondition") QueryCondition queryCondition);

    /**
     * 根据id获得Project
     * @param id
     * @return
     */
    Project getProject(@Param("id") String id);
}
