package com.xlkj.website.service;


import com.xlkj.website.model.GarbageBagDto;
import com.xlkj.website.model.OrderFormAddDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SelectOrderDto;

import java.util.List;

public interface OrderFormService {

    //新增订单
    public ResultVo<String> addOrderForm(OrderFormAddDto dto);

    //订单修改
    public ResultVo<Integer> modifyOrderForm(OrderFormAddDto dto);

    //订单列表
    public ResultVo<List<OrderFormAddDto>> listOrderForm(SelectOrderDto dto);

    //订单新增垃圾袋
    ResultVo<Integer> addGarbageBag(GarbageBagDto dto);

}
