package com.apps.omnipotent.system.core;
/**
 * Created by cles on 2020/5/31 12:12
 */

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.exception.MyException;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
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
        String tableName = getTableName();
        List<JSONObject> list =  getTableField();
        /*
          根据类获取注解信息
         */
        Db.use().save(tableName,list);
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
    private List<JSONObject> getTableField()  {
        List<JSONObject> list = new ArrayList<>();
        String tableName = getTableName();
        Class<? extends BaseModel> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.err.println(fields.length);
        for (Field field : fields){
            String column = field.getName();
            JSONObject obj = new JSONObject();
            obj.put("entity_field", column);
            Type type = field.getGenericType();
            if (int.class.equals(type)) {
                obj.put("field_type","int");
            }else if(String.class.equals(type)){
                obj.put("field_type","String");
            }else if(Date.class.equals(type)){
                obj.put("field_type","Date");
            }
            /*field.setAccessible(true);
            try {
                System.err.println(field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);*/

            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object value = getMethod.invoke(this);
                obj.put("field_value", value);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            obj.put("table_name", tableName);
            obj.put("entity_name", clazz.getName());
            boolean tableFieldExists = field.isAnnotationPresent(TableField.class);
            if(tableFieldExists){
                TableField tableField = field.getDeclaredAnnotation(TableField.class);
                column = tableField.value();
            }
            obj.put("table_field", column);
            list.add(obj);
        }
        return list;
    }


}