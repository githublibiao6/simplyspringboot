package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.dao.DicTeamsDao;
import com.apps.omnipotent.manager.service.DictionaryTeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictionaryTeamsServiceImpl implements DictionaryTeamsService {

    @Autowired
    private DicTeamsDao dao;

    /**
     * @Description: 添加字典
     * @Param: [m]
     * @return: boolean
     * @Author: cles
     * @Date: 2020/6/3 23:43
     */
    @Override
    public boolean add(DictionaryTeams m) {
        return m.save();
    }

    /**
     * 功能描述：
     *  < 更新字典 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/6/21 23:47
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    @Override
    public boolean update(DictionaryTeams m) {
        return m.update();
    }

    /**
     * 功能描述：
     *  < 根据主键删除字典 >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:20
     * @param id 字典主键
     * @return: boolean
     * @version: 1.0.0
     */
    @Override
    public boolean remove(String id) {
        DictionaryTeams mode = new DictionaryTeams();
        mode.setId(id);
        return mode.delete();
    }
}
