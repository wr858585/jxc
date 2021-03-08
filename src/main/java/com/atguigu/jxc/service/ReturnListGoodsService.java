package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

public interface ReturnListGoodsService {

    /**
     * 退货单保存商品
     * @param returnListGoodsStr
     * @return
     */
    ServiceVO saveReturnListGoods(Integer returnListId, String returnListGoodsStr);
}
