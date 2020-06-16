package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 22:53
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.bean.Record;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import com.apps.omnipotent.system.db.factory.DbMaker;
import com.apps.omnipotent.system.utils.StringUtil;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description: 数据库操作实体
 * @author cles
 * @Date 2020/5/10 22:53
 */
@Data
public class DbPro {

    private static DruidDataSource dataSource;
    /**
     * 默认的主键
     */
    private static String DEFAULT_PRIMARY_KEY  = "id";
    public DbPro(){

    }
    public String getUserName(){
        return dataSource.getUsername();
    }

    public String getPassword(){
        return dataSource.getPassword();
    }

    public String getDbType(){
        return dataSource.getDbType();
    }

    public String getTableSchema(){
        if("oracle".equals(getDbType())){
            return getUserName();
        }else if("mysql".equals(getDbType())){
            Map  m =  findFirst("select database() table_schema");
            if(m != null && m.get("table_schema") != null && StringUtil.notBlank(m.get("table_schema").toString())){
                return m.get("table_schema").toString();
            }else {
                return null;
            }
        }
        return null;
    }

    public DbPro(DruidDataSource dataSource){
        DbPro.dataSource = dataSource;
    }

    public  List<Map> find(String sql){
        return DbHelper.find(dataSource,sql);
    }

    public List<JSONObject> findList(String sql){
        return DbHelper.findList(dataSource,sql);
    }
    public Map findFirst(String sql){
        List<Map> list = find(sql);
        if (list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public int  deleteById(String tableName,String primaryKey, String id){
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).deleteSql(tableName,primaryKey,id);
        return DbHelper.update(dataSource,sql);
    }

    /**
    * @Description: 根据id删除
    * @Param: [tableName, id]
    * @return: int
    * @Author: cles
    * @Date: 2020/6/14 23:25
    */
    public int  deleteById(String tableName, String id){
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).deleteSql(tableName,getPrimaryKey(tableName).get(0),id);
        return DbHelper.update(dataSource, sql);
    }

    public int  delete(String sql){
        DbHelper.update(dataSource , sql);
        return 1;
    }

    public String save(String tableName, List<JSONObject> list) {
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).saveSql(tableName,getPrimaryKey(tableName).get(0),list);
        int n = DbHelper.save(dataSource,sql);
        return "";
    }

    /**
    * @Description: 获取主键
    * @Param: [tableName]
    * @return: java.util.List<java.lang.String>
    * @Author: cles
    * @Date: 2020/6/16 23:31
    */
    private List<String> getPrimaryKey(String tableName){
        TableInfo table = MainDb.getTableInfo(tableName);
        List<String> pks = table.getPks();
        if(pks == null || pks.size() == 0){
            throw new RuntimeException(this.getClass()+"has no primary key");
        }else {
            return pks;
        }
    }
}
