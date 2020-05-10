package com.apps.omnipotent.system.bean;
/**
 * Created by cles on 2020/5/10 23:24
 */

import java.util.Map;

/**
 * @description: 实体
 * @author cles
 * @Date 2020/5/10 23:24
 */
public class Record {

    private Map<String , Object> map ;

    public String getString(String column){
        Object o = map.get(column);
        if(o == null){
            return null;
        }
        return o.toString();
    }
}
