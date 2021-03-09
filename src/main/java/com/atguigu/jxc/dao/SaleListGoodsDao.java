package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.StatsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zllstart
 * @create 2021-03-08-21:21
 */
public interface SaleListGoodsDao {
    void updateState(@Param(" ") Integer saleListId);

    List<StatsVo> getSaleDataByDay(@Param("sTime") String sTime, @Param("eTime") String eTime);
}
