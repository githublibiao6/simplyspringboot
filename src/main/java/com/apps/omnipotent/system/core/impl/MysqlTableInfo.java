package com.apps.omnipotent.system.core.impl;
/**
 * Created by cles on 2020/6/4 23:14
 */

import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.db.utils.Db;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2020/6/4 23:14
 */
public class MysqlTableInfo implements DbTableInfo {
    @Override
    public List<Map> listTable() {
        return Db.use().find("");
    }

    @Override
    public List<Map> listTableColumns() {
        return Db.use().find("");
    }
}
