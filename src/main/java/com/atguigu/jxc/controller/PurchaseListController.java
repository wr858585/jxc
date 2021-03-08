package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description 购买订单Controller控制器
 */
@RestController
@RequestMapping("/purchaseList")
public class PurchaseListController {

    /**
     * 添加或修改供应商
     * @param supplier 供应商实体
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "供应商管理")
    public ServiceVO save(Supplier supplier) {
        return null;
    }

}
