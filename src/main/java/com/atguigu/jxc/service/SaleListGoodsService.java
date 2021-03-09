package com.atguigu.jxc.service;

import java.util.Map;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;

public interface SaleListGoodsService {
    Map<String, Object> listBy(String saleNumber, Integer customerId, Integer state, String sTime, String eTime);

    Map<String, Object> showDetails(Integer saleListId);

    Boolean deleteBySid(Integer saleListId);

    Boolean deleteBySidOnSaleListGoods(Integer saleListId);

    ServiceVO save(SaleList saleList, String saleListGoodsStr);

    void updateState(Integer saleListId);
}
