package com.apps.omnipotent.manager.dictionary.service;

import com.apps.omnipotent.manager.dictionary.dao.DicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DicService {
    
    @Autowired
    private DicDao dao;
}
