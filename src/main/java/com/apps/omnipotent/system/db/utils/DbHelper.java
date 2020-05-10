package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 23:22
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.apps.omnipotent.system.bean.Record;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: 数据库操作
 * @author cles
 * @Date 2020/5/10 23:22
 */
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

            e.printStackTrace();
        }
        return conn;
    }

    public static List<Record> find(DruidDataSource dataSource, String sql) {
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        // todo DruidDataSource使用jdbc 连接操作数据
        return null;
    }
}
