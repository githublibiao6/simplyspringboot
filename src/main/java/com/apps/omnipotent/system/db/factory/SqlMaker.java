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
    * @Description: 保存实体类的sql语句
     * @Param: [tableName, list]
    * @return: java.lang.String
    * @Author: cles
    * @Date: 2020/6/16 23:03
    */
    public  String saveSql(String tableName,String primaryKey, List<JSONObject> list) {
//        INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
        StringBuilder sql = new StringBuilder("INSERT INTO "+tableName);
        return sql.toString();
    }
}
