package com.apps.omnipotent.system.db.factory.impl;
/**
 * Created by cles on 2020/5/31 20:54
 */

import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.core.impl.MysqlTableInfo;
import com.apps.omnipotent.system.db.factory.DbFactory;
import com.apps.omnipotent.system.db.factory.SqlMaker;
import com.apps.omnipotent.system.db.factory.TableInfo;
import com.apps.omnipotent.system.db.utils.Db;

/**
 * @description: sql语句生成工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
public class MysqlFactory implements DbFactory {

    @Override
    public SqlMaker getSqlMaker() {
        return new MysqlSqlMaker();
    }

    @Override
    public DbTableInfo getTableInfo() {
        return new MysqlTableInfo();
    }
}
