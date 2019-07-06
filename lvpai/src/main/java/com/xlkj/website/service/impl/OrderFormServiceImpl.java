package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.OrderFormMapper;
import com.xlkj.website.model.OrderFormAddDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SelectOrderDto;
import com.xlkj.website.service.OrderFormService;
import com.xlkj.website.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    private OrderFormMapper orderFormMapper;

    //订单新增
    @Override
    public ResultVo<Integer> addOrderForm(OrderFormAddDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        //生成订单编码
        String prefix="LP";
        dto.setOrderCode(NumberUtil.getBusinessCode(prefix));
        Integer add = orderFormMapper.addOrderForm(dto);
        resultVo.setData(dto.getOid());
        resultVo.resultFlag(resultVo,add,"新增成功","新增失败");
        return resultVo;
    }

    //订单修改
    @Override
    public ResultVo<Integer> modifyOrderForm(OrderFormAddDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer mod = orderFormMapper.modifyOrderForm(dto);
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
}
