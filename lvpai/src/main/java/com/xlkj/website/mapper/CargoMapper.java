package com.xlkj.website.mapper;

import com.xlkj.website.model.CargoDto;
import com.xlkj.website.model.OrderDetailsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CargoMapper {

    Integer addCargo(CargoDto dto);

    Integer modifyCargo(CargoDto dto);

    List<CargoDto> listCargo(Integer cid);

    List<OrderDetailsDto> listOrderDetails(String bagCode);

    Integer addOrderDetails(OrderDetailsDto orderDetailsDto);
}
