package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.PurchaseListQueryVo;
import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

/**
 * @author zqq
 * @create 2021-03-08 15:03
 */
public interface PurchaseListGoodsService {
    Integer savePurchaseListGoods(String purchaseListGoodsStr, Integer purchaseListId);

    Map<String, Object> purchaseListListByQueryParam(PurchaseListQueryVo purchaseListQueryVo);

    Map<String, Object> queryGoodsByPurchaseListId(Integer purchaseListId);

    ServiceVO deletePurchaseListById(Integer purchaseListId);
}
