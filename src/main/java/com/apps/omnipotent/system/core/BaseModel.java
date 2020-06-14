package com.apps.omnipotent.system.core;
/**
 * Created by cles on 2020/5/31 12:12
 */

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.exception.MyException;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 尝试
 * @author cles
 * @Date 2020/5/31 12:12
 */

public abstract class BaseModel<T extends BaseModel> implements Serializable {

    /**
    * @Description: 保存
    * @Param: []
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:58
    */
    public boolean save(){
        // todo
        Object obj = new Object[0];
        String tableName = getTableName();
        /**
         * 根据类获取注解信息
         */
        Db.use().save(tableName);
        return true;
    }

    /**
    * @Description: 不加主键的保存
    * @Param: []
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:58
    */
    public boolean save2(){
        String tableName = getTableName();
        /**
         * 根据类获取注解信息
         */
        Db.use().deleteById(tableName,null);
        return true;
    }

    /**
     * @Description: 删除、找到主键
     * @Param: []
     * @return: boolean
     * @Author: cles
     * @Date: 2020/6/3 23:57
     */
    public boolean delete(){
        String tableName = getTableName();
        /**
         * 根据类获取注解信息
         */
        Db.use().deleteById(tableName,null);
        return true;
    }

    public boolean deleteById(String id){
        String tableName = getTableName();
        /**
         * 根据类获取注解信息
         */
        int delete = Db.use().deleteById(tableName, id);
        return delete > 0;
    }

    public boolean update(){
        String tableName = getTableName();
        /**
         * 根据类获取注解信息
         */
        Db.use().deleteById(tableName,null);
        return true;
    }

    public Object findById(){
        String tableName = getTableName();
        return true;
    }

    /**
    * @Description: 根据实体类的注解获取表名
    * @Param: []
    * @return: java.lang.String
    * @Author: cles
    * @Date: 2020/6/3 23:57
    */
    private String getTableName(){
        String tableName = "";
        boolean tableAnnExits = this.getClass().isAnnotationPresent(Table.class);
        if(tableAnnExits){
            Table table = this.getClass().getAnnotation(Table.class);
            tableName = table.value();
        }else {
            throw new RuntimeException(this.getClass()+"has not bind table");
        }
        return tableName;
    }

    //todo 获取字典映射关系
    private List<String> getTablefield(){
        String tableName = "";
        boolean tableAnnExits = this.getClass().isAnnotationPresent(Table.class);
        if(tableAnnExits){
            Table table = this.getClass().getAnnotation(Table.class);
            tableName = table.value();
        }else {
            throw new RuntimeException(this.getClass()+"has not bind table");
        }
        return null;
    }


}