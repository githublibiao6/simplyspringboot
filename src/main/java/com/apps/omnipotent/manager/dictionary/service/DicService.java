package com.apps.omnipotent.manager.dictionary.service;

import com.apps.omnipotent.manager.dictionary.bean.Dictionary;
import com.apps.omnipotent.manager.dictionary.dao.DicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DicService {
    
    @Autowired
    private DicDao dao;

    /**
    * @Description: 获取全部字典
    * @Param: []
    * @return: java.util.List<com.apps.omnipotent.manager.dictionary.bean.Dictionary>
    * @Author: cles
    * @Date: 2020/5/13 23:28
    */
    public List<Dictionary> list(){
        return dao.listDictionary();
    }
}
