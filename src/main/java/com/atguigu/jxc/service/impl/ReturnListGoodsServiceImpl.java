package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.domain.PurchaseVo;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zllstart
 * @create 2021-03-09-9:36
 */
@Service
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Autowired
    private ReturnListGoodsDao returnListGoodsDao;
    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<PurchaseVo> list = this.returnListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
