package com.xlkj.website.mapper;

import com.xlkj.website.model.CommonSearchDto;
import com.xlkj.website.model.HomePageOrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomePageMapper {

    HomePageOrderDto countOrder();

    Integer countUser(CommonSearchDto commonSearchDto);

    Integer countEqu();
}

