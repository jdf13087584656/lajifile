package com.xlkj.website.service;

import com.xlkj.website.model.BagCargoDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {

    ResultVo<List<BagCargoDto>> listOrderDetails(String bagCode);

    ResultVo<Integer> addOrderDetails(OrderDetailsDto orderDetailsDto);
}
