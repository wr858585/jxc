package com.atguigu.jxc.service;

/**
 * @author zllstart
 * @create 2021-03-08-21:19
 */
public interface SaleListGoodsService {
    void updateState(Integer saleListId);

    String getSaleDataByDay(String sTime, String eTime);
}
