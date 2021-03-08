package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListDao;
import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.UserDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.*;
import com.atguigu.jxc.service.CustomerReturnListService;
import com.atguigu.jxc.service.LogService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.ref.PhantomReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerReturnListServiceImpl implements CustomerReturnListService {
    @Autowired
    private CustomerReturnListDao customerReturnListDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private LogService logService;

    @Override
    public ServiceVO save(CustomerReturnList customerReturnList, String customerReturnListGoodsStr) {
        Gson gson = new Gson();
        List<CustomerReturnListGoods> customerReturnListGoodsList = gson.fromJson(customerReturnListGoodsStr, new TypeToken<List<CustomerReturnListGoods>>() {
        }.getType());
        // 设置当前操作用户
        User currentUser = userDao.findUserByName((String) SecurityUtils.getSubject().getPrincipal());
        customerReturnList.setUserId(currentUser.getUserId());
        customerReturnListDao.saveCustomerReturnList(customerReturnList);
        for (CustomerReturnListGoods customerReturnListGoods : customerReturnListGoodsList) {
            customerReturnListGoods.setCustomerReturnListId(customerReturnList.getCustomerReturnListId());
            customerReturnListDao.saveReturnListGoods(customerReturnListGoods);
            //相应商品库存进行添加
            Goods goods = goodsDao.findByGoodsId(customerReturnListGoods.getGoodsId());
            goods.setInventoryQuantity(goods.getInventoryQuantity() + customerReturnListGoods.getGoodsNum());
            goods.setState(2);
            goodsDao.updateGoods(goods);
        }
        // 保存日志
        logService.save(new Log(Log.INSERT_ACTION, "新增商品退货单：" + customerReturnList.getReturnNumber()));
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public Map<String, Object> list(String returnNumber, Integer customerId, Integer state, String sTime, String eTime) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> returnList = customerReturnListDao.getReturnList(returnNumber, customerId, state, sTime, eTime);
        logService.save(new Log(Log.SELECT_ACTION, "商品退货单据查询"));
        result.put("rows", returnList);
        return result;
    }

    @Override
    public Map<String, Object> goodsList(Integer customerReturnListId) {
        List<Map<String, Object>> mapList = customerReturnListDao.getGoodsListByReturnListId(customerReturnListId);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", mapList);
        return map;
    }

    @Override
    @Transactional
    public ServiceVO deleteReturnList(Integer customerReturnListId) {
        customerReturnListDao.deleteReturnGoodsList(customerReturnListId);
        customerReturnListDao.deleteReturnList(customerReturnListId);
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
