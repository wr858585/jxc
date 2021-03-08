package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.ReturnList;

import java.util.List;
import java.util.Map;

public interface CustomerReturnListDao {
    Integer saveCustomerReturnList(CustomerReturnList customerReturnList);
    Integer saveReturnListGoods(CustomerReturnListGoods customerReturnListGoods);
    List<Map<String,Object>> getReturnList(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);

    List<Map<String,Object>> getGoodsListByReturnListId(Integer customerReturnListId);

    void deleteReturnList(Integer customerReturnListId);

    void deleteReturnGoodsList(Integer customerReturnListId);
}
