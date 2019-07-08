package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.OrderFormMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.BalanceService;
import com.xlkj.website.service.OrderFormService;
import com.xlkj.website.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer mod = orderFormMapper.modifyOrderForm(dto);
        if(mod > 0 && dto.getOrderState() == 4 && null != dto.getAllPrice()){
            AddBalanceDto addBalanceDto = new AddBalanceDto();
            addBalanceDto.setChange(dto.getAllPrice());
            balanceService.modifyBalance(addBalanceDto);
        }
        resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
        return resultVo;
    }


    //订单列表
    @Override
    public ResultVo<List<OrderFormAddDto>> listOrderForm(SelectOrderDto dto) {
        ResultVo<List<OrderFormAddDto>> resultVo = new ResultVo<>();
        List<OrderFormAddDto> orders = orderFormMapper.listOrderForm(dto);
        resultVo.resultSuccess(orders);
        return resultVo;
    }

    //订单新增垃圾袋
    @Override
    public ResultVo<Integer> addGarbageBag(GarbageBagDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        List<String> bagCodes = dto.getBagCodes();
        if(null != bagCodes && bagCodes.size()>0){
            for(int i=0;i<bagCodes.size();i++){
                dto.setBagCode(bagCodes.get(i));
                Integer add =orderFormMapper.addGarbageBag(dto);
                resultVo.resultFlag(resultVo,add,"操作成功","操作失败");
            }
        }
        return resultVo;
    }
}
