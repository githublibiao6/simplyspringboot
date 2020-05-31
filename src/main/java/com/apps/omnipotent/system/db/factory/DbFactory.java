package com.apps.omnipotent.system.db.factory;
/**
 * Created by cles on 2020/5/31 20:54
 */

/**
 * @description: 数据库工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
public interface DbFactory {
    /**
     * 获取sql创建方法
     * @return
     */
    SqlMaker getSqlMaker();
}
