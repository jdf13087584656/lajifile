package com.xlkj.website.mapper;

import com.xlkj.website.model.*;
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

    //二维码查看详情接口
    OrderFormAddDto OrderFormDetails(String code);

    //订单新增垃圾袋
    Integer addGarbageBag(GarbageBagDto dto);

    //用户绑定垃圾袋接口(仅绑定,无订单)
    Integer addRoleGarbageBag(RoleGarbageDto dto);

    //删除绑定垃圾袋接口(仅绑定,无订单)
    Integer deleteRoleGarbageBag(String openId);

    //用户垃圾袋列表接口(仅绑定,无订单)
    String listRoleGarbageBag(String openId);

    //定点回收
    RoleGarbageDto designatedRecycling(String bagCode);

}
