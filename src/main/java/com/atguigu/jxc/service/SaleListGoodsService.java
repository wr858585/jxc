package com.atguigu.jxc.service;

public interface SaleListGoodsService {
    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);

    String getSaleDataByDay(String sTime, String eTime);

}
