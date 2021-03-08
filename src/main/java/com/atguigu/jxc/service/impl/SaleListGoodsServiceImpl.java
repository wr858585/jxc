package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {
    @Override
    public Map<String, Object> listBy(String saleNumber, Integer customerId, Integer state, String sTime, String eTime) {
        return null;
    }
}
