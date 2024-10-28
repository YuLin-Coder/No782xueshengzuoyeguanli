package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.XueshengZuoyeDao;
import com.entity.XueshengZuoyeEntity;
import com.service.XueshengZuoyeService;
import com.entity.view.XueshengZuoyeView;

/**
 * 作业 服务实现类
 * @author 
 * @since 2021-03-24
 */
@Service("xueshengZuoyeService")
@Transactional
public class XueshengZuoyeServiceImpl extends ServiceImpl<XueshengZuoyeDao, XueshengZuoyeEntity> implements XueshengZuoyeService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XueshengZuoyeView> page =new Query<XueshengZuoyeView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
