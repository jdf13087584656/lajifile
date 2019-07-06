package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.CargoMapper;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.orderDetailsDto;
import com.xlkj.website.service.OederDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class OederDetailsServiceImpl implements OederDetailsService {

    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public ResultVo<List<orderDetailsDto>> listOrderDetails(Integer oid) {
        ResultVo<List<orderDetailsDto>> resultVo = new ResultVo<>();
        List<orderDetailsDto> list = cargoMapper.listOrderDetails(oid);
        resultVo.resultSuccess(list);
        return resultVo;
    }

    @Override
    public ResultVo<Integer> addOrderDetails(orderDetailsDto orderDetailsDto) {
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
