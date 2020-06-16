package com.apps.omnipotent.system.db.factory.impl;
/**
 * Created by cles on 2020/5/31 21:42
 */

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.db.factory.SqlMaker;

import java.util.List;

/**
 * @description:
 * @author cles
 * @Date 2020/5/31 21:42
 */
public class OracleSqlMaker extends SqlMaker {

    @Override
    public String saveSql(String tableName, String primaryKey, List<JSONObject> list) {
        return null;
    }

    @Override
    public String updateSql(String tableName, String primaryKey, List<JSONObject> list) {
        return null;
    }
}
