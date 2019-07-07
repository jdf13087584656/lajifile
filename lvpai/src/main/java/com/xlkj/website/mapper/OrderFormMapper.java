package com.xlkj.website.mapper;

import com.xlkj.website.model.GarbageBagDto;
import com.xlkj.website.model.OrderFormAddDto;
import com.xlkj.website.model.SelectOrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderFormMapper {

    //新增订单
    Integer addOrderForm(OrderFormAddDto dto);

    //修改订单
    Integer modifyOrderForm(OrderFormAddDto dto);

    //订单列表
    List<OrderFormAddDto> listOrderForm(SelectOrderDto dto);

    //订单新增垃圾袋
    Integer addGarbageBag(GarbageBagDto dto);

}
