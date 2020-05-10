package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 22:53
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.apps.omnipotent.system.bean.Record;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 数据库操作实体
 * @author cles
 * @Date 2020/5/10 22:53
 */
@Data
public class DbPro {

    private static DruidDataSource dataSource;
    public DbPro(){

    }
    public DbPro(DruidDataSource dataSource){
        DbPro.dataSource = dataSource;
    }

    public static List<Record> find(String sql){
        return DbHelper.find(dataSource,sql);
    }
    public static Record findFirst(String sql){
        List<Record> list = find(sql);
        if (list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
