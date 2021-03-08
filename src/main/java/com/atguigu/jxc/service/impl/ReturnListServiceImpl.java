package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListDao;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnListServiceImpl implements ReturnListService {

    @Autowired
    private ReturnListDao returnListDao;

    @Override
    public Integer saveReturnList(ReturnList returnList) {
        return returnListDao.saveReturnList(returnList);
    }
}
