package com.apps.omnipotent.system.utils;
/**
 * Created by cles on 2020/5/30 0:33
 */

import com.apps.omnipotent.system.bean.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 转换工具类
 * @author cles
 * @Date 2020/5/30 0:33
 */
public class ConvertUtils {

    /**
    * @Description:  list 转换为tree
    * @Param: [list, pid]
    * @return: void
    * @Author: cles
    * @Date: 2020/5/30 0:34
    */
    private void convertTree(List<Record> list,String idField, String parentField,
                             String childrenField ,String pid, boolean removeChildren){
        List<Record> children = new ArrayList<>();
        list.forEach(t->{
            if(pid.equals(t.getString(parentField))){
                for (Record record : list) {
                    if(record.getString(parentField).equals(t.getString(idField))){
                        children.add(record);
                    }
                }
                if(children.size() > 0){
                    children.forEach(child->{
                        convertTree(list,idField,parentField,childrenField,t.getString(idField),removeChildren);
                    });
                    t.setString(childrenField,children);
                }
            }
        });
        if(removeChildren){
            children.forEach(list::remove);
        }
    }
}
