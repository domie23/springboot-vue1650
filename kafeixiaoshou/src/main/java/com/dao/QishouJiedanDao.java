package com.dao;

import com.entity.QishouJiedanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QishouJiedanView;

/**
 * 骑手接单 Dao 接口
 *
 * @author 
 */
public interface QishouJiedanDao extends BaseMapper<QishouJiedanEntity> {

   List<QishouJiedanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
