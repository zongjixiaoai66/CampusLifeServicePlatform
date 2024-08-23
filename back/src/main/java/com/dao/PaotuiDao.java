package com.dao;

import com.entity.PaotuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuiView;

/**
 * 跑腿 Dao 接口
 *
 * @author 
 */
public interface PaotuiDao extends BaseMapper<PaotuiEntity> {

   List<PaotuiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
