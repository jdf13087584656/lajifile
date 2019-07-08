package com.xlkj.website.mapper;

import com.xlkj.website.model.AddBalanceDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BalanceMapper {
    Integer addBalance(AddBalanceDto dto);

    AddBalanceDto searchBalance(String openId);

    Integer modifyBalance(AddBalanceDto dto);
}
