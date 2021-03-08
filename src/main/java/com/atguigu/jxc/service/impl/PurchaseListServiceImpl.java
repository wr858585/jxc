package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListDao;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zqq
 * @create 2021-03-08 15:03
 */
@Service
public class PurchaseListServiceImpl implements PurchaseListService {

    @Autowired
    private PurchaseListDao purchaseListDao;
    @Override
    public Integer savePurchaseList(PurchaseList purchaseList) {
        return this.purchaseListDao.savePurchaseList(purchaseList);
    }
}
