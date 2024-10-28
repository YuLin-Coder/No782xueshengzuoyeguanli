package com.dao;

import com.entity.XueshengZuoyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengZuoyeView;

/**
 * 作业 Dao 接口
 *
 * @author 
 * @since 2021-03-24
 */
public interface XueshengZuoyeDao extends BaseMapper<XueshengZuoyeEntity> {

   List<XueshengZuoyeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
