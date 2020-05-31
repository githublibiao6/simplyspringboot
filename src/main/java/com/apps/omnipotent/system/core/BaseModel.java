package com.apps.omnipotent.system.core;
/**
 * Created by cles on 2020/5/31 12:12
 */

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.exception.MyException;

import java.io.Serializable;

/**
 * @description: 尝试
 * @author cles
 * @Date 2020/5/31 12:12
 */

public abstract class BaseModel<T extends BaseModel> implements Serializable {

    public boolean delete(){
        String tableName = getTableName();
        /**
         * 根据类获取注解信息
         */
        Db.use().deleteById(tableName,null);
        return true;
    }

    private String getTableName(){
        String tableName = "";
        boolean tableAnnoExits = this.getClass().isAnnotationPresent(Table.class);
        if(tableAnnoExits){
            Table table = this.getClass().getAnnotation(Table.class);
            tableName = table.value();
        }else {
            throw new RuntimeException(this.getClass()+"has not bind table");
        }
        return tableName;
    }


}