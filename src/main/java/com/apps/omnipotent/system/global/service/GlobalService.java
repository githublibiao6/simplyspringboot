package com.apps.omnipotent.system.global.service;

import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class GlobalService {

    public PageEntity getPageEntity(List<?> list, PageEntity entity){
        int pageNum = entity.getPage();
        int pageSize = entity.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<?> info = new PageInfo<>(list);
        return PageUtils.getPageResult(entity,info);

    }
}
