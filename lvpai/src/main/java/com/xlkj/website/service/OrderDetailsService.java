package com.xlkj.website.service;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {

    ResultVo<List<OrderDetailsDto>> listOrderDetails(String bag_code);

    ResultVo<Integer> addOrderDetails(OrderDetailsDto orderDetailsDto);
}
