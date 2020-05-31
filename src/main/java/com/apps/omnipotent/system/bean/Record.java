package com.apps.omnipotent.system.bean;
/**
 * Created by cles on 2020/5/10 23:24
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 实体
 * @author cles
 * @Date 2020/5/10 23:24
 */
public class Record  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String , Object> map = new HashMap<>();

    public void setMap(Map<String , Object> map){
        this.map = map;
    }

    public Map<String , Object> getMap(){
        return this.map;
    }

    public String getString(String column){
        Object o = map.get(column);
        if(o == null){
            return null;
        }
        return o.toString();
    }

    public void setString(String column, Object value){
        map.put(column,value);
    }

    @Override
    public String toString(){
        return map.toString();
    }
}
