package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListDao;
import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.domain.PurchaseListQueryVo;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zqq
 * @create 2021-03-08 15:03
 */
@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {
    @Autowired
    private PurchaseListDao purchaseListDao;
    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @Autowired
    private GoodsService goodsService;

    @Override
    public Integer savePurchaseListGoods(String purchaseListGoodsStr, Integer purchaseListId) {
        // 反序列化purchaseListGoodsStr
        Gson gson = new Gson();
        List<PurchaseListGoods> purchaseListGoodsList = gson.fromJson(purchaseListGoodsStr, new TypeToken<List<PurchaseListGoods>>() {
        }.getType());

        Integer count = 0;
        for (PurchaseListGoods purchaseListGoods : purchaseListGoodsList) {
            purchaseListGoods.setPurchaseListId(purchaseListId);
            // 加库存
            goodsService.updateCount(purchaseListGoods.getGoodsId(), purchaseListGoods.getGoodsNum());
            if (this.purchaseListGoodsDao.savePurchaseListGoods(purchaseListGoods) == 1) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<String, Object> purchaseListListByQueryParam(PurchaseListQueryVo purchaseListQueryVo) {
        List<PurchaseList> purchaseListList = this.purchaseListDao.purchaseListListByQueryParam(purchaseListQueryVo);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", purchaseListList);
        return map;
    }

    @Override
    public Map<String, Object> queryGoodsByPurchaseListId(Integer purchaseListId) {
        List<PurchaseListGoods> purchaseListGoodsList = this.purchaseListGoodsDao.queryGoodsByPurchaseListId(purchaseListId);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", purchaseListGoodsList);
        return map;

    }

    @Override
    public ServiceVO deletePurchaseListById(Integer purchaseListId) {
        this.purchaseListGoodsDao.deleteGoodsByPurchaseListId(purchaseListId);
        List<PurchaseListGoods> purchaseListGoodsList = this.purchaseListGoodsDao.queryGoodsByPurchaseListId(purchaseListId);
        for (PurchaseListGoods purchaseListGoods : purchaseListGoodsList) {
            purchaseListGoods.setPurchaseListId(purchaseListId);
            // 减库存
            goodsService.updateCount(purchaseListGoods.getGoodsId(), -purchaseListGoods.getGoodsNum());
        }
        this.purchaseListDao.deletePurchaseListById(purchaseListId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
