package com.xlkj.website.mapper;

import com.xlkj.website.model.CommonSearch;
import com.xlkj.website.model.OrderFormAddDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderFormMapper {

    //新增订单
    Integer addOrderForm(OrderFormAddDto dto);

    //修改订单
    Integer modifyOrderForm(OrderFormAddDto dto);

    //订单列表
    List<OrderFormAddDto> listOrderForm(CommonSearch com);

}
