package com.xlkj.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.OrderFormMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.BalanceService;
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
    @Autowired
    private BalanceService balanceService;

    //订单新增
    @Override
    public ResultVo<String> addOrderForm(OrderFormAddDto dto) {
        ResultVo<String> resultVo = new ResultVo<>();
        //生成订单编码
        String prefix="LP";
        dto.setOrderCode(NumberUtil.getBusinessCode(prefix));
        Integer add = orderFormMapper.addOrderForm(dto);
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
}
