package com.apps.omnipotent.system.core;
/**
 * Created by cles on 2020/5/31 12:12
 */

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.utils.SessionUtils;
import com.apps.omnipotent.system.utils.StringUtil;
import org.springframework.format.annotation.DateTimeFormat;

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
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 尝试
 * @author cles
 * @Date 2020/5/31 12:12
 */

public abstract class BaseModel<T extends BaseModel> implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sys001;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sys002;
    private String sys003;
    private String sys004;
    private String sys005;
    private String sys006;
    private int sys007;
    
    private static final String CREATE_TIME_FIELD = "sys001";
    private static final String UPDATE_TIME_FIELD = "sys002";
    private static final String CREATE_USER_FIELD = "sys002";
    private static final String UPDATE_USER_FIELD = "sys002";
    private static final String TABLE_FIELD = "table_field";
    private static final String FIELD_VALUE = "field_value";
    /**
     * 功能描述：
     *  < 实体直接保存 >
     * @Description: save
     * @Author: cles
     * @Date: 2020/6/19 0:18
     * @return: String
     * @version: 1.0.0
     */
    public String save(){
        String tableName = getTableName();
        List<JSONObject> list =  getTableField();
        // 生成时间，与生成人员
        list.forEach(t->{
            if(CREATE_TIME_FIELD.equals(t.getString(TABLE_FIELD))){
                t.put(CREATE_TIME_FIELD,new Date());
            }
            if(CREATE_USER_FIELD.equals(t.getString(TABLE_FIELD))){
                t.put(CREATE_USER_FIELD, SessionUtils.getUserId());
            }
        });
        return Db.use().save(tableName, getPrimaryKey(tableName), list);
    }

    /**
     * 功能描述：
     *  < 直接删除实体 >
     * @Description: delete
     * @Author: cles
     * @Date: 2020/6/19 0:15
     * @return: boolean
     * @version: 1.0.0
     */
    public boolean delete(){
        String tableName = getTableName();
        List<JSONObject> list =  getTableField();
        String primaryKey = getPrimaryKey(tableName);
        AtomicReference<String> id = new AtomicReference<>("");
        list.forEach(t->{
            if(primaryKey.equals(t.getString(TABLE_FIELD))){
                id.set(t.getString(FIELD_VALUE));
            }
        });
        if(StringUtil.isBlank(id.get())){
            throw new RuntimeException("primary key can not be null");
        }
        Db.use().deleteById(tableName , getPrimaryKey(tableName) ,id.get());
        return true;
    }

    /**
     * 功能描述：
     *  < 根据值删除 >
     * @Description: deleteById
     * @Author: cles
     * @Date: 2020/6/19 0:14
     * @param id 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    public boolean deleteById(String id){
        if(StringUtil.isBlank(id)){
            throw new RuntimeException("primary key can not be null");
        }
        String tableName = getTableName();
        /*
         * 根据类获取注解信息
         */
        int delete = Db.use().deleteById(tableName, getPrimaryKey(tableName), id);
        return delete > 0;
    }

    /**
     * 功能描述：
     *  < 更新实体>
     * @Description: update
     * @Author: cles
     * @Date: 2020/6/19 0:16
     * @return: boolean
     * @version: 1.0.0
     */
    public boolean update(){
        String tableName = getTableName();
        List<JSONObject> list =  getTableField();
        list.forEach(t->{
            // 编辑时间，与编辑人员
            if(UPDATE_TIME_FIELD.equals(t.getString(TABLE_FIELD))){
                t.put(FIELD_VALUE,new Date());
            }
            if(UPDATE_USER_FIELD.equals(t.getString(TABLE_FIELD))){
                t.put(FIELD_VALUE,SessionUtils.getUserId());
            }
        });
        int res = Db.use().update(tableName, getPrimaryKey(tableName),list);
        return res>0;
    }

    public T findById(String id){
        String tableName = getTableName();
        return null;
    }

    /**
     * 功能描述：
     *  < 根据实体类的注解获取表名 >
     * @Description: getTableName
     * @Author: cles
     * @Date: 2020/6/19 0:17
     * @return: java.lang.String
     * @version: 1.0.0
     */
    private String getTableName(){
        String tableName = "";
        boolean tableAnnExits = this.getClass().isAnnotationPresent(Table.class);
        if(tableAnnExits){
            Table table = this.getClass().getAnnotation(Table.class);
            tableName = table.value();
        }else {
            throw new RuntimeException(this.getClass()+" has not bind table");
        }
        return tableName;
    }

    /**
     * 功能描述：
     *  < 将实体转换，保存表字段映射，值等 >
     * @Description: getTableField
     * @Author: cles
     * @Date: 2020/6/19 0:17
     * @return: java.util.List<com.alibaba.fastjson.JSONObject>
     * @version: 1.0.0
     */
    private List<JSONObject> getTableField()  {
        List<JSONObject> list = new ArrayList<>();
        String tableName = getTableName();
        Class<? extends BaseModel> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            String column = field.getName();
            JSONObject obj = new JSONObject();
            obj.put("entity_field", column);
            Type type = field.getGenericType();
            if (int.class.equals(type) || Integer.class.equals(type)) {
                obj.put("field_type","int");
            }else if(String.class.equals(type)){
                obj.put("field_type","String");
            }else if(Date.class.equals(type)){
                obj.put("field_type","Date");
            }
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object value = getMethod.invoke(this);
                obj.put(FIELD_VALUE, value);
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
            obj.put(TABLE_FIELD, column);
            list.add(obj);
        }
        return list;
    }

    /**
     * @Description: 获取主键
     * @Param: [tableName]
     * @return: java.util.List<java.lang.String>
     * @Author: cles
     * @Date: 2020/6/16 23:31
     */
    private String getPrimaryKey(String tableName){
        TableInfo table = MainDb.getTableInfo(tableName);
        List<String> pks = table.getPks();
        if(pks == null || pks.size() == 0){
            throw new RuntimeException(this.getClass()+"has no primary key");
        }else {
            return pks.get(0);
        }
    }

    public Date getSys001() {
        return sys001;
    }

    public void setSys001(Date sys001) {
        this.sys001 = sys001;
    }

    public Date getSys002() {
        return sys002;
    }

    public void setSys002(Date sys002) {
        this.sys002 = sys002;
    }

    public String getSys003() {
        return sys003;
    }

    public void setSys003(String sys003) {
        this.sys003 = sys003;
    }

    public String getSys004() {
        return sys004;
    }

    public void setSys004(String sys004) {
        this.sys004 = sys004;
    }

    public String getSys005() {
        return sys005;
    }

    public void setSys005(String sys005) {
        this.sys005 = sys005;
    }

    public String getSys006() {
        return sys006;
    }

    public void setSys006(String sys006) {
        this.sys006 = sys006;
    }

    public int getSys007() {
        return sys007;
    }

    public void setSys007(int sys007) {
        this.sys007 = sys007;
    }

}