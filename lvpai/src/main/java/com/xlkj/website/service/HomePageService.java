package com.xlkj.website.service;

import com.xlkj.website.model.CommonSearchDto;
import com.xlkj.website.model.HomePageOrderDto;
import com.xlkj.website.model.ResultVo;

public interface HomePageService {

    ResultVo<HomePageOrderDto> countOrder();

    ResultVo<Integer> countUser(CommonSearchDto commonSearchDto);

    ResultVo<Integer> countEqu();
}
