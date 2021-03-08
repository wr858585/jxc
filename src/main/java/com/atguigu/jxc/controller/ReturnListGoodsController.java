package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.ReturnList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("returnListGoods")
public class ReturnListGoodsController {

    @PostMapping("save")
    public ServiceVO saveReturn(@RequestParam("returnNumber")String returnNumber,
                                @RequestBody ReturnList returnList,
                                @RequestBody String returnListGoodsStr){
return null;
    }

}
