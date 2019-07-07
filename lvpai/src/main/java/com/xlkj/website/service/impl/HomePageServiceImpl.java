package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.HomePageMapper;
import com.xlkj.website.model.CommonSearchDto;
import com.xlkj.website.model.HomePageOrderDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;
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
}
