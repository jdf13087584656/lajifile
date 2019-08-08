package com.xlkj.website.service;


import com.xlkj.website.model.*;

import java.util.List;

public interface OrderFormService {

    //新增订单
    public ResultVo<String> addOrderForm(OrderFormAddDto dto);

    //订单修改
    public ResultVo<Integer> modifyOrderForm(OrderFormAddDto dto);

    //订单列表
    public ResultVo<List<OrderFormAddDto>> listOrderForm(SelectOrderDto dto);

    //二维码查看详情接口
    public ResultVo<OrderFormAddDto> OrderFormDetails(String code);

    //订单新增垃圾袋
    ResultVo<Integer> addGarbageBag(GarbageBagDto dto);

    //用户绑定垃圾袋接口(仅绑定,无订单)
    ResultVo<Integer> addRoleGarbageBag(RoleGarbageDto dto);

    //用户垃圾袋列表接口(仅绑定,无订单)
    ResultVo<String> listRoleGarbageBag(String openId);

    //用户垃圾袋删除接口(仅绑定,无订单)
    ResultVo<Integer> deleteRoleGarbageBag(String openId);

    //定点回收
    ResultVo<Integer> designatedRecycling(String bagCode,Integer receiverId);

}
