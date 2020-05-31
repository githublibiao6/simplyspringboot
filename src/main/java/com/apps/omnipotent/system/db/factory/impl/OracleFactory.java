package com.apps.omnipotent.system.db.factory.impl;
/**
 * Created by cles on 2020/5/31 20:54
 */

import com.apps.omnipotent.system.db.factory.DbFactory;
import com.apps.omnipotent.system.db.factory.SqlMaker;

/**
 * @description: sql语句生成工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
public class OracleFactory implements DbFactory {

    @Override
    public SqlMaker getSqlMaker() {
        return new OracleSqlMaker();
    }
}
