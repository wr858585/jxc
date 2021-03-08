package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zqq
 * @create 2021-03-08 15:03
 */
@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {
    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;
    @Override
    public Integer savePurchaseListGoods(String purchaseListGoodsStr) {
        // 反序列化purchaseListGoodsStr
        Gson gson = new Gson();
        List<PurchaseListGoods>  purchaseListGoodsList= gson.fromJson(purchaseListGoodsStr, new TypeToken<List<PurchaseListGoods>>() {}.getType());

        Integer count=0;
        for (PurchaseListGoods purchaseListGoods : purchaseListGoodsList) {
            if (this.purchaseListGoodsDao.savePurchaseListGoods(purchaseListGoods)==1){
                count++;
            }
        }
        return count;
    }
}
