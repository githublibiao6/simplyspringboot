package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 23:22
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.apps.omnipotent.system.bean.Record;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数据库操作
 * @author cles
 * @Date 2020/5/10 23:22
 */
@Slf4j
public class DbHelper {
    private static DbHelper instance = null;

    private DbHelper() {

    }

    /**
     * @return
     * @Description: 获取实例
     * @date 2017年7月28日
     */
    public synchronized static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    public DruidPooledConnection getConnection(DruidDataSource dataSource) {
        DruidPooledConnection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            log.info("数据源"+dataSource.getUrl()+"获取不到连接");
            e.printStackTrace();
        }
        return conn;
    }

    /**
    * @Description: 获取
    * @Param: [dataSource, sql]
    * @return: java.util.List<com.apps.omnipotent.system.bean.Record>
    * @Author: cles
    * @Date: 2020/5/11 0:15
    */
    public static List<Record> find(DruidDataSource dataSource, String sql) {
        //2. 获得数据库连接
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        //3.操作数据库，实现增删改查
        Statement stmt = null;
        List<Record> list = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //如果有数据，rs.next()返回true
            Record record = new Record();
            //获取列集
            ResultSetMetaData metaData = rs.getMetaData();
            //获取列的数量
            int columnCount = metaData.getColumnCount();
            while(rs.next()){
                for (int i = 0; i < columnCount; i++) {
                    //通过序号获取列名,起始值为1
//                    String columnName = metaData.getColumnName(i+1);
                    String columnName = metaData.getColumnLabel(i+1);
                    //通过列名获取值.如果列值为空,columnValue为null,不是字符型
                    String columnValue = rs.getString(columnName);
                    record.setString(columnName,columnValue);
                }
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


        // todo DruidDataSource使用jdbc 连接操作数据
        return list;
    }

    /**
    * @Description: 删除
    * @Param: [dataSource, sql]
    * @return: java.lang.Integer
    * @Author: cles
    * @Date: 2020/5/31 20:32
    */
    public static Integer update(DruidDataSource dataSource, String sql) {
        //2. 获得数据库连接
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        //3.操作数据库，实现增删改查
        Statement stmt = null;
        List<Record> list = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);
            //如果有数据，rs.next()返回true
            if(rs>0) {
                // 删除成功 提交事务
                //提交事务
                conn.commit();
            }else{
                // 删除失败 回滚事务
                conn.rollback();
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
