package com.xlkj.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.OrderFormMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.OrderFormService;
import com.xlkj.website.util.DateUtil;
import com.xlkj.website.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    private OrderFormMapper orderFormMapper;

    //订单新增
    @Override
    public ResultVo<String> addOrderForm(OrderFormAddDto dto) {
        ResultVo<String> resultVo = new ResultVo<>();
        //生成订单编码
        String prefix="LP";
        dto.setOrderCode(NumberUtil.getBusinessCode(prefix));
        //如果无订单绑定袋子直接绑定此袋
        String bag = orderFormMapper.listRoleGarbageBag(dto.getOpenId());
        if(null != bag){
            GarbageBagDto gar = new GarbageBagDto();
            gar.setOid(dto.getOid());
            gar.setBagCode(bag);
            if(null != orderFormMapper.OrderFormDetails(bag)){
                resultVo.resultFail("此垃圾袋已绑定");
                return resultVo;
            }
            orderFormMapper.addGarbageBag(gar);
        }
        Integer add = orderFormMapper.addOrderForm(dto);
        orderFormMapper.deleteRoleGarbageBag(dto.getOpenId());
        if (add > 0){
            resultVo.resultSuccess("新增成功");
        }else{
            resultVo.resultFail("新增失败");
        }
        resultVo.setData(dto.getOrderCode());
        return resultVo;
    }

    //订单修改
    @Override
    public ResultVo<Integer> modifyOrderForm(OrderFormAddDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        //派单时间
        if(dto.getOrderState()==2){
            dto.setOrderSendTime(DateUtil.getStringDate());
        }
        //揽件时间
        if(dto.getOrderState()==3){
            dto.setOrderGetTime(DateUtil.getStringDate());
        }
        //完成时间
        if(dto.getOrderState()==4){
            dto.setOrderFinishTime(DateUtil.getStringDate());
        }
        BigDecimal a = new BigDecimal(0);
        Integer mod;
        //当传入oids不为null时,仅为管理员派单操作
        if(null != dto.getOids() && dto.getOids().size() > 0){
            for(int i=0;i<dto.getOids().size();i++){
                dto.setOid(dto.getOids().get(i));
                mod = orderFormMapper.modifyOrderForm(dto);
                resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
            }
            return resultVo;
        }
        //正常修改操作
        mod = orderFormMapper.modifyOrderForm(dto);
//        //如果有传入订单价格,执行修改余额操作
//        if(mod > 0 && null != dto.getAllPrice()){
//            AddBalanceDto addBalanceDto = new AddBalanceDto();
//            addBalanceDto.setChange(dto.getAllPrice());
//            if(null != addBalanceDto.getChange()){
//                balanceService.modifyBalance(addBalanceDto);
//            }
//        }
        resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
        return resultVo;
    }


    //订单列表
    @Override
    public ResultVo<List<OrderFormAddDto>> listOrderForm(SelectOrderDto dto) {
        PageHelper.startPage(dto.getCurrentPage(),dto.getPageSize());
        ResultVo<List<OrderFormAddDto>> resultVo = new ResultVo<>();
        List<OrderFormAddDto> orders = orderFormMapper.listOrderForm(dto);
        PageInfo<OrderFormAddDto> pageInfo = new PageInfo<>(orders);
        resultVo.setTotal((int) pageInfo.getTotal());
        resultVo.resultSuccess(orders);
        return resultVo;
    }

    //二维码查看详情接口
    @Override
    public ResultVo<OrderFormAddDto> OrderFormDetails(String code) {
        ResultVo<OrderFormAddDto> resultVo = new ResultVo<>();
        OrderFormAddDto order = orderFormMapper.OrderFormDetails(code);
        resultVo.resultSuccess(order);
        return resultVo;
    }

    //订单新增垃圾袋
    @Override
    public ResultVo<Integer> addGarbageBag(GarbageBagDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        List<String> bagCodes = dto.getBagCodes();
        if(null != bagCodes && bagCodes.size()>0){
            for(int i=0;i<bagCodes.size();i++){
                if(null == orderFormMapper.OrderFormDetails(dto.getBagCodes().get(i))){
                    dto.setBagCode(bagCodes.get(i));
                    //订单新增垃圾袋操作
                    Integer add =orderFormMapper.addGarbageBag(dto);
                    resultVo.resultFlag(resultVo,add,"订单垃圾袋新增成功","订单垃圾袋新增失败");
                }else{
                    resultVo.resultFail("此二维码已绑定其它订单");
                    return resultVo;
                }
            }
        }
        return resultVo;
    }

    //用户绑定垃圾袋接口(仅绑定,无订单)
    @Override
    public ResultVo<Integer> addRoleGarbageBag(RoleGarbageDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        //查看无订单袋码表有无数据
        RoleGarbageDto bag = orderFormMapper.designatedRecycling(dto.getBagCode());
        if(null != bag){
            resultVo.resultFail("此垃圾袋已绑定其它用户");
            return resultVo;
        }
        //查看订单表有无数据
        if(null != orderFormMapper.OrderFormDetails(dto.getBagCode())){
            resultVo.resultFail("此垃圾袋已绑定其它用户");
            return resultVo;
        }
        orderFormMapper.deleteRoleGarbageBag(dto.getOpenId());
        Integer add = orderFormMapper.addRoleGarbageBag(dto);
        resultVo.resultFlag(resultVo,add,"绑定成功","绑定失败");
        return resultVo;
    }

    //用户垃圾袋列表接口(仅绑定,无订单)
    @Override
    public ResultVo<String> listRoleGarbageBag(String openId) {
        ResultVo<String> resultVo = new ResultVo<>();
        String bagCode = orderFormMapper.listRoleGarbageBag(openId);
        resultVo.resultSuccess(bagCode);
        return resultVo;
    }

    //用户垃圾袋删除接口(仅绑定,无订单)
    @Override
    public ResultVo<Integer> deleteRoleGarbageBag(String openId) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer del = orderFormMapper.deleteRoleGarbageBag(openId);
        resultVo.resultFlag(resultVo,del,"解除成功","解除失败");
        return resultVo;
    }

    //定点回收
    @Override
    public ResultVo<Integer> designatedRecycling(DesignatedDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        OrderFormAddDto dtoo = new OrderFormAddDto();
        //查看无订单袋码表有无数据
        RoleGarbageDto bag = orderFormMapper.designatedRecycling(dto.getBagCode());
        //如果有数据
        if(null != bag){
            //生成订单编码
            String prefix="LP";
            dtoo.setOrderCode(NumberUtil.getBusinessCode(prefix));
            dtoo.setOpenId(bag.getOpenId());
            dtoo.setOrderState(2);
            dtoo.setOrderType(1);
            dtoo.setReceiveId(dto.getReceiveId());
            dtoo.setOrderSendTime(DateUtil.getStringDate());
            Integer add = orderFormMapper.addOrderForm(dtoo);
            GarbageBagDto gar = new GarbageBagDto();
            gar.setOid(dtoo.getOid());
            gar.setBagCode(dto.getBagCode());
            orderFormMapper.addGarbageBag(gar);
            resultVo.setData(dtoo.getOid());
            resultVo.resultFlag(resultVo,add,"下单成功","下单失败");
        }else{
            resultVo.resultFail("袋号未绑定,请先绑定再执行操作");
        }
        return resultVo;
    }

}
