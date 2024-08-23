package com.dao;

import com.entity.WenyuOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenyuOrderView;

/**
 * 商品订单 Dao 接口
 *
 * @author 
 */
public interface WenyuOrderDao extends BaseMapper<WenyuOrderEntity> {

   List<WenyuOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
