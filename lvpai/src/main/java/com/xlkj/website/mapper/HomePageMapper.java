package com.xlkj.website.mapper;

import com.xlkj.website.model.CommonSearchDto;
import com.xlkj.website.model.HomePageOrderDto;
import com.xlkj.website.model.SumDto;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface HomePageMapper {

    HomePageOrderDto countOrder();

    Integer countUser(CommonSearchDto commonSearchDto);

    Integer countEqu();

    List<SumDto> userStatistics(CommonSearchDto commonSearchDto);

    List<SumDto> userYSStatistics(CommonSearchDto commonSearchDto);

    BigDecimal roleEnergy(String openId);

    Integer userOrderAll(String account);

    Integer userYSOrderAll(String account);

    BigDecimal userPriceAll(String account);

    BigDecimal userYSPriceAll(String account);

    BigDecimal deductMoneyAll(String account);

    BigDecimal YSdeductMoneyAll(String account);
}

