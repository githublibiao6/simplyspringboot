package com.apps.omnipotent.business.service.impl;

import com.apps.omnipotent.business.dao.EssayDao;
import com.apps.omnipotent.business.entity.Essay;
import com.apps.omnipotent.business.service.EssayService;
import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.dao.DicDao;
import com.apps.omnipotent.manager.service.DictionaryService;
import com.apps.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class EssayServiceImpl implements EssayService {
    
    @Autowired
    private EssayDao dao;

    /**
    * @Description: 获取全部字典
    * @Param: []
    * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
    * @Author: cles
    * @Date: 2020/5/13 23:28
    */
    @Override
    public List<Essay> list(){
        return dao.listEssay();
    }

    /**
    * @Description: 添加字典
    * @Param: [m]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:43
    */
    @Override
    public boolean add(Essay m) {
        String id = m.save();
        return !StringUtil.isBlank(id);
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
    public boolean update(Essay m) {
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
        Essay mode = new Essay();
        mode.setId(id);
        return mode.delete();
    }
}
