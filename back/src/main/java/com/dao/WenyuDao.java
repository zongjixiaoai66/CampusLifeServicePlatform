package com.dao;

import com.entity.WenyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenyuView;

/**
 * 文娱活动 Dao 接口
 *
 * @author 
 */
public interface WenyuDao extends BaseMapper<WenyuEntity> {

   List<WenyuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
