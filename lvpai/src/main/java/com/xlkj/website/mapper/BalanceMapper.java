package com.xlkj.website.mapper;

import com.xlkj.website.model.AddBalanceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BalanceMapper {
    Integer addBalance(AddBalanceDto dto);

    AddBalanceDto searchBalance(String openId);

    Integer modifyBalance(AddBalanceDto dto);

    //余额归零
    Integer balanceZero (String openId);

    Integer secretKey(@Param("stime") String stime,@Param("secretKey") String secretKey);

    Integer searchSecretKey(@Param("stime") String stime,@Param("secretKey") String secretKey);
}
