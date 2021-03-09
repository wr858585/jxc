package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

public interface ReturnListGoodsService {

    /**
     * 退货单保存商品
     * @param returnListGoodsStr
     * @return
     */
    ServiceVO saveReturnListGoods(Integer returnListId, String returnListGoodsStr);

    Map<String, Object> queryReturnGoodsList(Integer returnListId);


    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
