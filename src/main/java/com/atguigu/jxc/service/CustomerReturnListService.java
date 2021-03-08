package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.CustomerReturnList;

import java.util.Map;

public interface CustomerReturnListService {
    ServiceVO save(CustomerReturnList customerReturnList, String customerReturnListGoodsStr);

    Map<String, Object> list(String returnNumber, Integer customerId, Integer state, String sTime, String eTime);

    Map<String, Object> goodsList(Integer customerReturnListId);

    ServiceVO deleteReturnList(Integer customerReturnListId);
}
