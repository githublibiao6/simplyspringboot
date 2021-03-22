package com.apps.omnipotent.system.global.service.impl;

import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
public class GlobalServiceImpl implements GlobalService {

    @Override
    public PageEntity getPageEntity(List list, PageEntity entity) {
        return null;
    }

    @Override
    public Object insertSelective(Object record) {
        return null;
    }
}
