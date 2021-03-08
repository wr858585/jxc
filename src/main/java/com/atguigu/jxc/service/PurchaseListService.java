package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.PurchaseList;

/**
 * @author zqq
 * @create 2021-03-08 15:03
 */
public interface PurchaseListService {
    /**
     * 保存入库单
     * @param purchaseList
     */
    Integer savePurchaseList(PurchaseList purchaseList);
}
