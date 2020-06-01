package com.apps.omnipotent.manager.service;

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.dao.DicDao;
import com.apps.omnipotent.manager.dao.DicTeamsDao;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictionaryTeamsService extends GlobalService {
    
    @Autowired
    private DicTeamsDao dao;

    public PageEntity pagelist(PageEntity entity,String dicId) {
        List<DictionaryTeams> pageMenus = dao.listTeamsByDicId(dicId);
        return getPageEntity(pageMenus,entity);
    }
}
