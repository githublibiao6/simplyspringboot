package com.apps.omnipotent.manager.service;

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.dao.DicDao;
import com.apps.omnipotent.system.db.utils.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictionaryService {
    
    @Autowired
    private DicDao dao;

    /**
    * @Description: 获取全部字典
    * @Param: []
    * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
    * @Author: cles
    * @Date: 2020/5/13 23:28
    */
    public List<Dictionary> list(){
        return dao.listDictionary();
    }

    /**
    * @Description: 添加字典
    * @Param: [m]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:43
    */
    public boolean add(Dictionary m) {

        return false;
    }
}