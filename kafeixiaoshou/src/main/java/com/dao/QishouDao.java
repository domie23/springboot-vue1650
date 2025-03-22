package com.dao;

import com.entity.QishouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QishouView;

/**
 * 骑手 Dao 接口
 *
 * @author 
 */
public interface QishouDao extends BaseMapper<QishouEntity> {

   List<QishouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
