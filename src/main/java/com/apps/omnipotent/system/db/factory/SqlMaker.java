package com.apps.omnipotent.system.db.factory;
/*
  Created by cles on 2020/5/31 21:41
 */

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @description: sql语句制造机
 * @author cles
 * @Date 2020/5/31 21:41
 */
public abstract class SqlMaker {

    public String deleteSql(String tableName,String primaryKey, String id){
        return "delete from "+tableName+" where "+primaryKey+"='"+id+"'";
    }

    /**
     * 保存实体类的sql语句
     * @param tableName
     * @param primaryKey
     * @param list
     * @return
     */
    public abstract String saveSql(String tableName,String primaryKey, List<JSONObject> list);

    /**
     * 保存实体类的sql语句
     * @param tableName
     * @param primaryKey
     * @param list
     * @return
     */
    public abstract String updateSql(String tableName,String primaryKey, List<JSONObject> list);
}
