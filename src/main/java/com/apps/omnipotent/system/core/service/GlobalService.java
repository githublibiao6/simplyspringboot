package com.apps.omnipotent.system.core.service;

import com.apps.omnipotent.system.bean.PageEntity;
import com.apps.omnipotent.system.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
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
