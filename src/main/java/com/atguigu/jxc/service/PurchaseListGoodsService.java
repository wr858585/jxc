package com.atguigu.jxc.service;

import java.util.Map;

/**
 * @author zllstart
 * @create 2021-03-08-14:59
 */
public interface PurchaseListGoodsService {
    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);

    Map<String, Object> list(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime);

    void updateState(Integer purchaseListId);
}
