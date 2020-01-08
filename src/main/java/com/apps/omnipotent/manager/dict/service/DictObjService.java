package com.apps.omnipotent.manager.dict.service;

import com.apps.omnipotent.manager.dict.dao.DictObjDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 字典对象 Service
 * @author lb
 *
 */
@Service
public class DictObjService {
    
    @Autowired
    private DictObjDao dao;
}
