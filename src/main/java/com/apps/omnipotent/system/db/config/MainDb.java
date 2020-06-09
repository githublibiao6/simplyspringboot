package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/31 18:29
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.db.bean.TableFieldInfo;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.factory.DbFactory;
import com.apps.omnipotent.system.db.factory.DbMaker;
import com.apps.omnipotent.system.db.utils.Db;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 默认数据源加入DB
 * @author cles
 * @Date 2020/5/31 18:29
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class MainDb {

    private static Map<String , TableInfo> map = new HashMap<>();

    private String url;
    private String username;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // application.properteis中对应属性的前缀
    @Bean(name = "main_db")
    public void dataSource() {
        DbConfig db = new DbConfig();
        DruidDataSource druidDataSource = db.buildDataSource(url,username,password,null);
        Db.setMain(druidDataSource);
    }

    /**
    * @Description: 初始化主数据源的表
    * @Param: []
    * @return: void
    * @Author: cles
    * @Date: 2020/6/9 23:32
    */
    public static void init(){
        DbTableInfo dbTableInfo = DbMaker.getDbTableInfo(Db.use().getDbType());
        List<Map> tables = dbTableInfo.listTable();
        List<Map> fields = dbTableInfo.listTableColumns();
        tables.forEach(t->{
            String tableName = t.get("table_name").toString();
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(tableName);
            List<TableFieldInfo> list = new ArrayList<>();
            List<String> pks = new ArrayList<>();
            fields.forEach(f->{
                if(tableName.equals(f.get("table_name"))){
                    TableFieldInfo field = convertField(f);
                    list.add(field);
                    if(field.isPk()){
                        pks.add(field.getColumnName());
                    }
                }
            });
            tableInfo.setFields(list);
            tableInfo.setPks(pks);
            map.put(tableName,tableInfo);
        });
    }

    /**
    * @Description: 将字段map转为字段实体
    * @Param: [map]
    * @return: com.apps.omnipotent.system.db.bean.TableFieldInfo
    * @Author: cles
    * @Date: 2020/6/9 23:32
    */
    private static TableFieldInfo convertField(Map map){
        TableFieldInfo field = new TableFieldInfo();
        if(map.get("column_name") != null){
            field.setColumnName(map.get("column_name").toString());
        }
        if(map.get("col_type") != null){
            field.setColType(map.get("col_type").toString());
        }
        if(map.get("col_length") != null){
            field.setColLength(map.get("col_length").toString());
        }
        field.setPk(false);
        if(map.get("pk") != null){
            field.setPk(true);
        }
        field.setColumnName("");
        return field;
    }

    /**
    * @Description: 获取主数据源表信息
    * @Param: [tableName]
    * @return: com.apps.omnipotent.system.db.bean.TableInfo
    * @Author: cles
    * @Date: 2020/6/9 23:34
    */
    public static TableInfo getTableInfo(String tableName){
        return map.get(tableName);
    }
}
