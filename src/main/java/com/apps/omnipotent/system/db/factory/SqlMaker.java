package com.apps.omnipotent.system.db.factory;
/**
 * Created by cles on 2020/5/31 21:41
 */

/**
 * @description: sql语句制造机
 * @author cles
 * @Date 2020/5/31 21:41
 */
public abstract class SqlMaker {

    public String deleteSql(String tableName,String primaryKey, String id){
        return "delete from "+tableName+" where "+primaryKey+"='"+id+"'";
    }
}
