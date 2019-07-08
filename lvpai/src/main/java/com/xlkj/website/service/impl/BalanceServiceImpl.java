package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.BalanceMapper;
import com.xlkj.website.model.AddBalanceDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;
    //余额新增
    @Override
    public ResultVo<Integer> addBalance(AddBalanceDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer add = balanceMapper.addBalance(dto);
        resultVo.resultFlag(resultVo,add,"新增成功","新增失败");
        return resultVo;
    }
    //余额查询
    @Override
    public ResultVo<AddBalanceDto> searchBalance(String openId) {
        ResultVo<AddBalanceDto> resultVo = new ResultVo<>();
        AddBalanceDto addBalanceDto = balanceMapper.searchBalance(openId);
        resultVo.resultSuccess(addBalanceDto);
        return resultVo;
    }
    //余额修改
    @Override
    public ResultVo<Integer> modifyBalance(AddBalanceDto dto) {
        BigDecimal a = new BigDecimal(0);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(null != dto.getChange() && dto.getChange().compareTo(a) == 1){
            AddBalanceDto addBalanceDto = balanceMapper.searchBalance(dto.getOpenId());
            dto.setBalance(addBalanceDto.getBalance().add(dto.getChange()));
        }
        Integer mod = balanceMapper.modifyBalance(dto);
        resultVo.resultFlag(resultVo,mod,"操作成功","操作失败");
        return resultVo;
    }
}
