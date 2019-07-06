package com.xlkj.website.service;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.orderDetailsDto;

import java.util.List;

public interface OederDetailsService {

    ResultVo<List<orderDetailsDto>> listOrderDetails(Integer oid);

    ResultVo<Integer> addOrderDetails(orderDetailsDto orderDetailsDto);
}
