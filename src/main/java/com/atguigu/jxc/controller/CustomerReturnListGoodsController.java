package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.service.CustomerReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customerReturnListGoods")
public class CustomerReturnListGoodsController {


    @Autowired
    private CustomerReturnListService customerReturnListService;

    @RequestMapping(value = "/save")
    public ServiceVO save(CustomerReturnList customerReturnList, String customerReturnListGoodsStr) {
        return customerReturnListService.save(customerReturnList, customerReturnListGoodsStr);
    }

    @RequestMapping("/list")
    public Map<String, Object> list(String returnNumber, Integer customerId, Integer state, String sTime, String eTime) {
        return customerReturnListService.list(returnNumber, customerId, state, sTime, eTime);
    }

    @RequestMapping("/goodsList")
    public Map<String, Object> goodsList(Integer customerReturnListId) {
        return customerReturnListService.goodsList(customerReturnListId);
    }

    @RequestMapping("/delete")
    public ServiceVO deleteReturnList(Integer customerReturnListId) {
        System.out.println(customerReturnListId);
        return customerReturnListService.deleteReturnList(customerReturnListId);
    }
}
