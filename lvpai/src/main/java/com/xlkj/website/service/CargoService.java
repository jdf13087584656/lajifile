package com.xlkj.website.service;

import com.xlkj.website.model.CargoDto;
import com.xlkj.website.model.ResultVo;

import java.util.List;

public interface CargoService {
    ResultVo<Integer> addCargo(CargoDto dto);

    ResultVo<Integer> modifyCargo(CargoDto dto);

    ResultVo<List<CargoDto>> listCargo();
}
