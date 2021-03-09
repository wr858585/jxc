package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListDao;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.PurchaseListService;
import com.atguigu.jxc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zqq
 * @create 2021-03-08 15:03
 */
@Service
public class PurchaseListServiceImpl implements PurchaseListService {

    @Autowired
    private PurchaseListDao purchaseListDao;

    @Autowired
    private UserService userService;
    @Override
    public Integer savePurchaseList(PurchaseList purchaseList, HttpSession session) {
        // 拿到用户的id
        User user = (User)session.getAttribute("currentUser");
        purchaseList.setUserId(user.getUserId());
        purchaseList.setTrueName(user.getTrueName());
        this.purchaseListDao.savePurchaseList(purchaseList);
        // 拿到当前入库单的id
        return purchaseList.getPurchaseListId();
    }
}
