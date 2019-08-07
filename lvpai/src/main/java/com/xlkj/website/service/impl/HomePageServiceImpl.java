package com.xlkj.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.CargoMapper;
import com.xlkj.website.mapper.HomePageMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;
    @Autowired
    private CargoMapper cargoMapper;
    @Override
    public ResultVo<HomePageOrderDto> countOrder() {
        ResultVo<HomePageOrderDto> resultVo = new ResultVo<>();
        HomePageOrderDto homePageOrderDto = homePageMapper.countOrder();
        resultVo.resultSuccess(homePageOrderDto);
        return resultVo;
    }

    @Override
    public ResultVo<Integer> countUser(CommonSearchDto commonSearchDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer users = homePageMapper.countUser(commonSearchDto);
        resultVo.resultSuccess(users);
        return resultVo;
    }

    @Override
    public ResultVo<Integer> countEqu() {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer equ = homePageMapper.countEqu();
        resultVo.resultSuccess(equ);
        return resultVo;
    }

    //回收
    @Override
    public ResultVo<List<SumDto>> userStatistics(CommonSearchDto dto) {
        ResultVo<List<SumDto>> resultVo = new ResultVo<>();
        //总订单数
        Integer orderNum = homePageMapper.userOrderAll(dto.getAccount());
        //总价
        BigDecimal allPrice = homePageMapper.userPriceAll(dto.getAccount());
        //总扣款
        BigDecimal deductMoneyAll = homePageMapper.deductMoneyAll(dto.getAccount());
        //总质量
        BigDecimal weightAll = homePageMapper.userWeightAll(dto.getAccount());
        PageHelper.startPage(dto.getCurrentPage(),dto.getPageSize());
        List<SumDto> sumDto = homePageMapper.userStatistics(dto);
        if(sumDto.size()>0){
            sumDto.get(0).setOrderSum(orderNum);
            sumDto.get(0).setAllPrice(allPrice);
            sumDto.get(0).setDeductMoneyAll(deductMoneyAll);
            sumDto.get(0).setAllWeight(weightAll);
            for(int i=0;i<sumDto.size();i++){
                CargoDto cargoDto = cargoMapper.searchCargo(sumDto.get(i).getCargoName());
                sumDto.get(i).setPriceSum(sumDto.get(i).getWeightSum().multiply(cargoDto.getCargoPrice()));
            }
            PageInfo<SumDto> pageInfo = new PageInfo<>(sumDto);
            resultVo.setTotal((int)pageInfo.getTotal());
            resultVo.resultSuccess(sumDto);
        }
        return resultVo;
    }

    //验收
    @Override
    public ResultVo<List<SumDto>> userYSStatistics(CommonSearchDto dto) {
        ResultVo<List<SumDto>> resultVo = new ResultVo<>();
        //总订单数
        Integer orderNum = homePageMapper.userYSOrderAll(dto.getAccount());
        //总价
        BigDecimal allPrice = homePageMapper.userYSPriceAll(dto.getAccount());
        //总扣款
        BigDecimal deductMoneyAll = homePageMapper.YSdeductMoneyAll(dto.getAccount());
        //总质量
        BigDecimal weightAll = homePageMapper.userYSWeightAll(dto.getAccount());
        PageHelper.startPage(dto.getCurrentPage(),dto.getPageSize());
        List<SumDto> sumDto = homePageMapper.userYSStatistics(dto);
        if(sumDto.size()>0){
            sumDto.get(0).setOrderSum(orderNum);
            sumDto.get(0).setAllPrice(allPrice);
            sumDto.get(0).setDeductMoneyAll(deductMoneyAll);
            sumDto.get(0).setAllWeight(weightAll);
            for(int i=0;i<sumDto.size();i++){
                CargoDto cargoDto = cargoMapper.searchCargo(sumDto.get(i).getCargoName());
                sumDto.get(i).setPriceSum(sumDto.get(i).getWeightSum().multiply(cargoDto.getCargoPrice()));
            }
            PageInfo<SumDto> pageInfo = new PageInfo<>(sumDto);
            resultVo.setTotal((int)pageInfo.getTotal());
            resultVo.resultSuccess(sumDto);
        }
        return resultVo;
    }

    @Override
    public ResultVo<BigDecimal> roleEnergy(String openId) {
        ResultVo<BigDecimal> resultVo = new ResultVo<>();
        BigDecimal roleEnergy = homePageMapper.roleEnergy(openId);
        resultVo.resultSuccess(roleEnergy);
        return resultVo;
    }
}
