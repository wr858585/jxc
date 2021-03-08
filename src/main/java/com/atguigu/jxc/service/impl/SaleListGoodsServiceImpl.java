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
    }
}
