package com.apps.omnipotent.manager.dictionary.service;

import com.apps.omnipotent.manager.dictionary.dao.DicTeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 字典对象 Service
 * @author lb
 *
 */
@Service
public class DicTeamsService {
    
    @Autowired
    private DicTeamsDao dao;
}
