package com.apps.omnipotent.manager.dict.service;

import com.apps.omnipotent.manager.dict.dao.DictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictService {
    
    @Autowired
    private DictDao dao;
}
