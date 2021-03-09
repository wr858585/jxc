package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zqq
 * @create 2021-03-08 15:19
 */
public interface PurchaseListGoodsDao {
    Integer savePurchaseListGoods(PurchaseListGoods purchaseListGoods);

    List<PurchaseList> purchaseListListByQueryParam();

    List<PurchaseListGoods> queryGoodsByPurchaseListId(@Param("purchaseListId") Integer purchaseListId);

    Integer deleteGoodsByPurchaseListId( Integer purchaseListId);
}
