package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListGoodsDao;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {

    @Autowired
    private CustomerReturnListGoodsDao customerReturnListGoodsDao;

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVo> saleListGoodsVos = customerReturnListGoodsDao.count(sTime,eTime,goodsTypeId,codeOrName);

        // 使用谷歌Gson将JSON字符串数组转换成具体的集合
        Gson gson = new Gson();
        String str=gson.toJson(saleListGoodsVos);
        System.out.println(str);
        return str;
    }
}
