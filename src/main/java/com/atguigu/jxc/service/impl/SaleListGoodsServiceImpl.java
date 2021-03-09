package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    SaleListGoodsDao saleListGoodsDao;

    @Override
    public Map<String, Object> listBy(String saleNumber, Integer customerId, Integer state, String sTime, String eTime) {
        List<Map<String,Object>> saleLists = saleListGoodsDao.listBy(saleNumber,customerId,state,sTime,eTime);
        Map<String, Object> map = new HashMap<>();

        map.put("rows",saleLists);
        return map;
    }

    @Override
    public Map<String, Object> showDetails(Integer saleListId) {
        List<Map<String,Object>> saleListGoods =  saleListGoodsDao.showDetails(saleListId);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",saleListGoods);
        return map;
    }

    @Override
    public Boolean deleteBySid(Integer saleListId) {
        return saleListGoodsDao.deleteBySid(saleListId);
    }

    @Override
    public Boolean deleteBySidOnSaleListGoods(Integer saleListId) {
        return saleListGoodsDao.deleteBySidOnSaleListGoods(saleListId);
import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.dao.UserDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.*;
import com.atguigu.jxc.service.LogService;
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
    private UserDao userDao;
    @Autowired
    private LogService logService;
    @Autowired
    private SaleListGoodsDao saleListGoodsDao;
    @Autowired
    private GoodsDao goodsDao;

    //当用户点击保存，进行销售出库单新增，同时相应商品库存进行扣减
    @Override
    public ServiceVO save(SaleList saleList, String saleListGoodsStr) {
        Gson gson = new Gson();
        List<SaleListGoods> saleListGoodsList = gson.fromJson(saleListGoodsStr, new TypeToken<List<SaleListGoods>>() {
        }.getType());
        // 设置当前操作用户
        User currentUser = userDao.findUserByName((String) SecurityUtils.getSubject().getPrincipal());
        saleList.setUserId(currentUser.getUserId());
        // 保存出库单
        saleListGoodsDao.saveSaleList(saleList);
        for (SaleListGoods saleListGoods : saleListGoodsList) {
            saleListGoods.setSaleListId(saleList.getSaleListId());
            saleListGoodsDao.saveSaleListGoods(saleListGoods);
            //相应商品库存进行扣减
            Goods goods = goodsDao.findByGoodsId(saleListGoods.getGoodsId());
            goods.setInventoryQuantity(goods.getInventoryQuantity() - saleListGoods.getGoodsNum());
            goods.setState(2);
            goodsDao.updateGoods(goods);
        }
        // 保存日志
        logService.save(new Log(Log.INSERT_ACTION, "新增商品售出单："+saleList.getSaleNumber()));
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
