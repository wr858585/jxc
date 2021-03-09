package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Resource
    private ReturnListGoodsDao returnListGoodsDao;

    @Resource
    private GoodsDao goodsDao;

    @Override
    public ServiceVO saveReturnListGoods(Integer returnListId, String returnListGoodsStr) {
        //反序列化returnListGoodsStr表单提交的字符串（退货商品map序列化提交的）
        Gson gson = new Gson();
        List<ReturnListGoods> returnListGoodsList = gson.fromJson(returnListGoodsStr, new TypeToken<List<ReturnListGoods>>() {}.getType());
        for (ReturnListGoods returnListGoods : returnListGoodsList) {
            //保存退货单商品列表
            returnListGoods.setReturnListId(returnListId);
            returnListGoodsDao.saveReturnListGoods(returnListGoods);
            //减库存
            Goods goods = goodsDao.findByGoodsId(returnListGoods.getGoodsId());
            goods.setInventoryQuantity(goods.getInventoryQuantity() - returnListGoods.getGoodsNum());
            goodsDao.updateGoods(goods);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public Map<String, Object> queryReturnGoodsList(Integer returnListId) {
        HashMap<String, Object> map = new HashMap<>();
        List<Map<String, Object>> returnGoodsLists = returnListGoodsDao.queryReturnGoodsList(returnListId);
        map.put("rows",returnGoodsLists);
        return map;
    }

}
