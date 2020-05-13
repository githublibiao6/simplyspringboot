package com.apps.omnipotent.manager.dictionary.service;

import com.apps.omnipotent.manager.dictionary.bean.DictionaryTeams;
import com.apps.omnipotent.manager.dictionary.dao.DicTeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典对象 Service
 * @author lb
 *
 */
@Service
public class DicTeamsService {
    
    @Autowired
    private DicTeamsDao dao;

    public List<DictionaryTeams> listTeamsByDicId(String id) {
        return dao.listTeamsByDicId(id);
    }
}
