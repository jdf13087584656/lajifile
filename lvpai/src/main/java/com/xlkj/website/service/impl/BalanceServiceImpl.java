package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.BalanceMapper;
import com.xlkj.website.model.AddBalanceDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.BalanceService;
import com.xlkj.website.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

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
        AddBalanceDto addBalanceDto = balanceMapper.searchBalance(dto.getOpenId());
        dto.setBalance(addBalanceDto.getBalance().add(dto.getChange()));
        Integer mod = balanceMapper.modifyBalance(dto);
        resultVo.resultFlag(resultVo,mod,"操作成功","操作失败");
        return resultVo;
    }

    //添加秘钥
    @Override
    public ResultVo<String> secretKey(String stime) {
        ResultVo<String> resultVo = new ResultVo<>();
        //通过当前时间加密
        String secretKey = Md5Util.MD5Encode(stime,"utf8",false);
        Integer add = balanceMapper.secretKey(stime,secretKey);
        if(add>0){
            resultVo.setData(secretKey);
        }else{
            resultVo.resultFail("添加失败");
        }
        return resultVo;
    }

    //查询秘钥
    @Override
    public ResultVo<Integer> searchSecretKey(String stime,String secretKey) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer sel = balanceMapper.searchSecretKey(stime,secretKey);
        if(1==sel){
            resultVo.setMsg("查询成功");
        }else{
            resultVo.resultFail("查询失败");
        }
        return resultVo;
    }
}
