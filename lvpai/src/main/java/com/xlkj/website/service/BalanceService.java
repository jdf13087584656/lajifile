package com.xlkj.website.service;

import com.xlkj.website.model.AddBalanceDto;
import com.xlkj.website.model.ResultVo;

public interface BalanceService {

    ResultVo<Integer> addBalance(AddBalanceDto dto);

    ResultVo<AddBalanceDto> searchBalance(String openId);

    ResultVo<Integer> modifyBalance(AddBalanceDto dto);
}
