package com.xlkj.website.mapper;

import com.xlkj.website.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CargoMapper {

    Integer addCargo(CargoDto dto);

    Integer modifyCargo(CargoDto dto);

    List<CargoDto> kidCargo(Integer pid);

    List<CargoDto> listCargo();

    CargoDto searchCargo(String cargoName);

    List<BagCargoDto> listOrderDetails(SearchCargoDto dto);

    Integer addOrderDetails(OrderDetailsDto orderDetailsDto);

}
