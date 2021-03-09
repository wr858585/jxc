package com.atguigu.jxc.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author zllstart
 * @create 2021-03-08-21:21
 */
public interface SaleListGoodsDao {
    void updateState(@Param(" ") Integer saleListId);
}
