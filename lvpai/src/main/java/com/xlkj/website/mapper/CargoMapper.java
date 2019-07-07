package com.xlkj.website.mapper;

import com.xlkj.website.model.BagCargoDto;
import com.xlkj.website.model.CargoDto;
import com.xlkj.website.model.OrderDetailsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CargoMapper {

    Integer addCargo(CargoDto dto);

    Integer modifyCargo(CargoDto dto);

    List<CargoDto> listCargo();

    List<BagCargoDto> listOrderDetails(String bagCode);

    Integer addOrderDetails(OrderDetailsDto orderDetailsDto);
}
