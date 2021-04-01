package com.apps.omnipotent.system.global.service.impl;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.global.dao.GlobalMapper;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;

import java.util.List;

/**
 * 功能描述：
 *  < 全局service方法 >
 * @Description:
 * @Author: cles
 * @Date: 2020/6/23 23:23
 * @return:
 * @version: 1.0.0
 */
public class  GlobalServiceImpl<T extends  BaseModel>  implements GlobalService<T> {

    private GlobalMapper<T> mapper;

    @Override
    public PageEntity getPageEntity(List list, PageEntity entity) {
        return null;
    }

    @Override
    public T detailQuery(String id) {
        return mapper.detailQuery(id);
    }

    @Override
    public BaseModel insertSelective(BaseModel record) {
        record.save();
        return record;
    }

    @Override
    public boolean deleteById(String primaryKey) {

        return false;
    }

    @Override
    public BaseModel updateSelective(BaseModel record) {
        record.update();
        return record;
    }

    @Override
    public boolean delete(BaseModel model) {
        try{
            model.delete();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
