package com.xlkj.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.CargoMapper;
import com.xlkj.website.mapper.OrderFormMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private CargoMapper cargoMapper;
    @Autowired
    private OrderFormMapper orderFormMapper;

    //货物信息列表
    @Override
    public ResultVo<List<BagCargoDto>> listOrderDetails(SearchCargoDto dto) {
        PageHelper.startPage(dto.getCurrentPage(),dto.getPageSize());
        ResultVo<List<BagCargoDto>> resultVo = new ResultVo<>();
        List<BagCargoDto> list = cargoMapper.listOrderDetails(dto);
        PageInfo<BagCargoDto> pageInfo = new PageInfo<>(list);
        resultVo.setTotal((int)pageInfo.getTotal());
        resultVo.resultSuccess(list);
        return resultVo;
    }

    //新增订单货物信息
    @Override
    public ResultVo<Integer> addOrderDetails(List<OrderDetailsDto> orderDetailsDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        //垃圾袋对象
        GarbageBagDto bagDto = new GarbageBagDto();
        OrderFormAddDto dto = new OrderFormAddDto();
        //将订单状态改为已揽件
        dto.setOrderState(3);
        dto.setOid(orderDetailsDto.get(0).getOid());
        orderFormMapper.modifyOrderForm(dto);
        //当前订单id
        for(int i=0;i<orderDetailsDto.size();i++){
            //订单新增垃圾袋操作
            bagDto.setOid(orderDetailsDto.get(0).getOid());
            bagDto.setBagCode(orderDetailsDto.get(i).getBagCode());
            Integer add =orderFormMapper.addGarbageBag(bagDto);
            resultVo.resultFlag(resultVo,add,"订单垃圾袋新增成功","订单垃圾袋新增失败");

            //当前垃圾袋内货物详情增加
            //货物详情集合(单价,质量)
            List<cargoQuality> cargoQualitiess = orderDetailsDto.get(i).getCargoQuality();
            if(null != cargoQualitiess && cargoQualitiess.size()>0){
                for(int ii=0;ii<cargoQualitiess.size();ii++){
                    //货物id
                    orderDetailsDto.get(i).setCid(cargoQualitiess.get(ii).getCid());
                    orderDetailsDto.get(i).setCargoWeight(cargoQualitiess.get(ii).getCargoWeight());
                    add = cargoMapper.addOrderDetails(orderDetailsDto.get(i));
                    resultVo.resultFlag(resultVo,add,"订单详情添加成功","订单详情添加成功");
                }
            }
        }
        return resultVo;
    }
}
