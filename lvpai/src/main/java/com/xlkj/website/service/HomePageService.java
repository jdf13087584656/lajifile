package com.xlkj.website.service;

import com.xlkj.website.model.CommonSearchDto;
import com.xlkj.website.model.HomePageOrderDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SumDto;

import java.math.BigDecimal;
import java.util.List;

public interface HomePageService {

    ResultVo<HomePageOrderDto> countOrder();

    ResultVo<Integer> countUser(CommonSearchDto commonSearchDto);

    ResultVo<Integer> countEqu();

    ResultVo<List<SumDto>> userStatistics(CommonSearchDto commonSearchDto);

    ResultVo<List<SumDto>> userYSStatistics(CommonSearchDto commonSearchDto);

    ResultVo<BigDecimal> roleEnergy(String openId);
}
