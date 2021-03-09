package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.StatsVo;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zllstart
 * @create 2021-03-08-21:19
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public void updateState(Integer saleListId) {
        this.saleListGoodsDao.updateState(saleListId);
    }

    @Override
    public String getSaleDataByDay(String sTime, String eTime) {
        List<StatsVo> list = this.saleListGoodsDao.getSaleDataByDay(sTime, eTime);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
