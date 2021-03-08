package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.dao.UserDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {
    @Autowired
    UserDao userDao;

    @Autowired
    SaleListGoodsDao saleListGoodsDao;
    //当用户点击保存，进行销售出库单新增，同时相应商品库存进行扣减
    @Override
    public ServiceVO save(SaleList saleList, String saleListGoodsStr) {
        Gson gson = new Gson();
        List<SaleListGoods> saleListGoods = gson.fromJson(saleListGoodsStr, new TypeToken<List<SaleListGoods>>() {
        }.getType());
        // 设置当前操作用户
        User currentUser = userDao.findUserByName((String) SecurityUtils.getSubject().getPrincipal());
        saleList.setUserId(currentUser.getUserId());
        // 保存出库单
        saleListGoodsDao.saveSaleList(saleList);
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
