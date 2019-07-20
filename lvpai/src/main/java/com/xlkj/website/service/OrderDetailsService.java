package com.xlkj.website.service;

import com.xlkj.website.model.BagCargoDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.OrderDetailsDto;
import com.xlkj.website.model.SearchCargoDto;

import java.util.List;

public interface OrderDetailsService {

    ResultVo<List<BagCargoDto>> listOrderDetails(SearchCargoDto dto);

    //新增货物信息详情
    ResultVo<Integer> addOrderDetails(OrderDetailsDto orderDetailsDto);
}
