package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.domain.PurchaseVo;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zllstart
 * @create 2021-03-08-15:00
 */
@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<PurchaseVo> list = this.purchaseListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @Override
    public Map<String, Object> list(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        Map<String, Object> map = new HashMap<>();
        List<PurchaseList> list = this.purchaseListGoodsDao.list(purchaseNumber,supplierId,state,sTime,eTime);
        map.put("rows", list);
        return map;
    }

    @Override
    public void updateState(Integer purchaseListId) {
        this.purchaseListGoodsDao.updateState(purchaseListId);
    }

    @Override
    public void save(String purchaseNumber,PurchaseList purchaseList, String purchaseListGoodsStr) {
        this.purchaseListGoodsDao.save(purchaseNumber,purchaseList, purchaseListGoodsStr);
    }
}
