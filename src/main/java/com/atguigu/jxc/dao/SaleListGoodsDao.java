package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.SaleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SaleListGoodsDao {
    List<Map<String,Object>> listBy(@Param("saleNumber") String saleNumber, @Param("customerId")Integer customerId, @Param("state")Integer state, @Param("sTime")String sTime, @Param("eTime")String eTime);

    List<Map<String, Object>> showDetails(Integer saleListId);

    Boolean deleteBySid(Integer saleListId);

    Boolean deleteBySidOnSaleListGoods(Integer saleListId);
}
