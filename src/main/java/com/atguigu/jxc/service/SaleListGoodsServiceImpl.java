package com.atguigu.jxc.service;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.SaleListGoods;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {
    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVo> saleListGoods=saleListGoodsDao.saleListGoods(sTime,eTime,goodsTypeId,codeOrName);

        // 使用谷歌Gson将JSON字符串数组转换成具体的集合
        Gson gson = new Gson();
        String str=gson.toJson(saleListGoods);
        System.out.println(str);
        return str;
    }
}
