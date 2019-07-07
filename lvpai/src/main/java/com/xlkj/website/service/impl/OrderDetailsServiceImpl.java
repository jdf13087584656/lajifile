package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.CargoMapper;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.OrderDetailsDto;
import com.xlkj.website.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private CargoMapper cargoMapper;

    //货物信息列表
    @Override
    public ResultVo<List<OrderDetailsDto>> listOrderDetails(String bagCode) {
        ResultVo<List<OrderDetailsDto>> resultVo = new ResultVo<>();
        List<OrderDetailsDto> list = cargoMapper.listOrderDetails(bagCode);
        resultVo.resultSuccess(list);
        return resultVo;
    }

    //新增订单货物信息
    @Override
    public ResultVo<Integer> addOrderDetails(OrderDetailsDto orderDetailsDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        List<Integer> cids = orderDetailsDto.getCids();
        List<BigDecimal> cargoWeights = orderDetailsDto.getCargoWeights();
        if(cids != null && cids.size() > 0){
            for(int i=0;i<cids.size();i++){
                orderDetailsDto.setCid(cids.get(i));
                orderDetailsDto.setCargoWeight(cargoWeights.get(i));
                Integer add =cargoMapper.addOrderDetails(orderDetailsDto);
                resultVo.resultFlag(resultVo,add,"操作成功","操作失败");
            }
        }
        return resultVo;
    }
}
