package com.apps.omnipotent.system.global.dao;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.core.Table;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 初始化mapper
 * @author cles
 * @param <T>
 */
public interface GlobalMapper<T extends BaseModel> {

    /**
     * 根据主键查询实体
     * @param id 主键
     * @return t
     */
    @SelectProvider(type = GlobalMapper.GlobalProvider.class,method = "detailQuery")
    T detailQuery(String id);


    class GlobalProvider{
        private  String getTableName(){
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
        public String detailQuery(String id) {

            return "select * from date_log m where m.sys005='1'";
        }
    }

}
