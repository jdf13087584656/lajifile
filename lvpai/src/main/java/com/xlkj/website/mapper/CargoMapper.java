package com.xlkj.website.mapper;

import com.xlkj.website.model.CargoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CargoMapper {

    Integer addCargo(CargoDto dto);

    Integer modifyCargo(CargoDto dto);

    List<CargoDto> listCargo(Integer cid);
}
