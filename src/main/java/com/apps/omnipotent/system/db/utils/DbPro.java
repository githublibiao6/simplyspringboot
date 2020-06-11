package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 22:53
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.apps.omnipotent.system.bean.Record;
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

    public List<Record> findRecord(String sql){
        return DbHelper.findRecord(dataSource,sql);
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

    public int  deleteById(String tableName, String id){
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).deleteSql(tableName,DEFAULT_PRIMARY_KEY,id);
        DbHelper.update(dataSource,sql);
        return 1;
    }

    public int  delete(String sql){
        DbHelper.update(dataSource , sql);
        return 1;
    }
}
