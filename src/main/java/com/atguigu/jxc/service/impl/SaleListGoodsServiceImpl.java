package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.dao.UserDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.*;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.GetSaleDataByDayVo;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zllstart
 * @create 2021-03-08-21:19
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    SaleListGoodsDao saleListGoodsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogService logService;
    @Autowired
    private GoodsDao goodsDao;

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
    }

    //??????????????????????????????????????????????????????????????????????????????????????????
    @Override
    public ServiceVO save(SaleList saleList, String saleListGoodsStr) {
        Gson gson = new Gson();
        List<SaleListGoods> saleListGoodsList = gson.fromJson(saleListGoodsStr, new TypeToken<List<SaleListGoods>>() {
        }.getType());
        // ????????????????????????
        User currentUser = userDao.findUserByName((String) SecurityUtils.getSubject().getPrincipal());
        saleList.setUserId(currentUser.getUserId());
        // ???????????????
        saleListGoodsDao.saveSaleList(saleList);
        for (SaleListGoods saleListGoods : saleListGoodsList) {
            saleListGoods.setSaleListId(saleList.getSaleListId());
            saleListGoodsDao.saveSaleListGoods(saleListGoods);
            //??????????????????????????????
            Goods goods = goodsDao.findByGoodsId(saleListGoods.getGoodsId());
            goods.setInventoryQuantity(goods.getInventoryQuantity() - saleListGoods.getGoodsNum());
            goods.setState(2);
            goodsDao.updateGoods(goods);
        }
        // ????????????
        logService.save(new Log(Log.INSERT_ACTION, "????????????????????????" + saleList.getSaleNumber()));
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public void updateState(Integer saleListId) {
        this.saleListGoodsDao.updateState(saleListId);
    }


    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVo> saleListGoods=saleListGoodsDao.saleListGoods(sTime,eTime,goodsTypeId,codeOrName);

        // ????????????Gson???JSON???????????????????????????????????????
        Gson gson = new Gson();
        String str=gson.toJson(saleListGoods);
        System.out.println(str);
        return str;
    }

    @Override
    public String getSaleDataByDay(String sTime, String eTime) {
        List<GetSaleDataByDayVo> getSaleDataByDayVos=saleListGoodsDao.getSaleDataByDay(sTime,eTime);
        getSaleDataByDayVos.stream().map(getSaleDataByDayVo -> {
            getSaleDataByDayVo.setProfit(getSaleDataByDayVo.getSaleTotal()-getSaleDataByDayVo.getPurchasingTotal());
            return getSaleDataByDayVo;
        }).collect(Collectors.toList());
        Gson gson = new Gson();
        String str=gson.toJson(getSaleDataByDayVos);
        System.out.println(str);
        return str;
    }

    @Override
    public String getSaleDataByMonth(String sTime, String eTime) {
        List<GetSaleDataByDayVo> getSaleDataByMonthVos=saleListGoodsDao.getSaleDataByMonth(sTime,eTime);
        getSaleDataByMonthVos.stream().map(getSaleDataByMonthVo -> {
            getSaleDataByMonthVo.setProfit(getSaleDataByMonthVo.getSaleTotal()-getSaleDataByMonthVo.getPurchasingTotal());
            return getSaleDataByMonthVo;
        }).collect(Collectors.toList());
        Gson gson = new Gson();
        String str=gson.toJson(getSaleDataByMonthVos);
        System.out.println(str);
        return str;
    }
}
