package com.atguigu.jxc.service;

import java.util.Map;

public interface SaleListGoodsService {
    Map<String, Object> listBy(String saleNumber, Integer customerId, Integer state, String sTime, String eTime);
}
